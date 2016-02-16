package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnVisionAuto extends Command {

    double[] centerX;
    double[] defaultValue = { -5.0, -5.0 };
    double testingDouble;
    double initialTime;
    double aimTimeMilli;
    double waitTimeMilli;
    double motorSpeed;

    public TurnVisionAuto() {
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.requires(Robot.feedSolenoid);
        this.requires(Robot.flipSolenoid);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.initialTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //Turns the motors based on a proportion of the distance left to turn
        int turning = this.dirTurning();
        this.motorSpeed = (0.0014516129
                * Math.abs(this.testingDouble - RobotMap.centerXTarget) + .370);
        //Turns only the front two motors
        Robot.leftS.moveSingle(this.motorSpeed * turning);
        Robot.rightS.moveSingle(this.motorSpeed * turning);

    }

    //Outputs to SmartDashboard which way the bot is turning
    public int dirTurning() {
        try {
            this.centerX = Robot.table.getNumberArray("centerX",
                    this.defaultValue);
            this.testingDouble = this.centerX[0];
            if (this.testingDouble > (RobotMap.centerXTarget
                    + RobotMap.targetSpread)) {
                SmartDashboard.putString("Vision Auto Turn Status: ",
                        "Turning left");
                return -1;
            } else if (this.testingDouble < (RobotMap.centerXTarget
                    - RobotMap.targetSpread)) {
                SmartDashboard.putString("Vision Auto Turn Status: ",
                        "Turning right");
                return 1;
            } else if ((this.testingDouble <= (RobotMap.centerXTarget
                    + RobotMap.targetSpread))
                    && (this.testingDouble >= (RobotMap.centerXTarget
                            - RobotMap.targetSpread))) {
                SmartDashboard.putString("Vision Auto Turn Status: ",
                        "Found Target");
                return 0;
            } else {
                SmartDashboard.putString("Vision Auto Turn Status: ",
                        "Something went wrong");
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return (this.testingDouble <= (RobotMap.centerXTarget
                + RobotMap.targetSpread))
                && (this.testingDouble >= (RobotMap.centerXTarget
                        - RobotMap.targetSpread));
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        //Robot.shooterWheels.shoot(0);
        SmartDashboard.putString("Vision Auto Turn Status: ", "On target");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        SmartDashboard.putString("Vision Auto Turn Status: ",
                "Auto Turn interrupted");
    }
}
