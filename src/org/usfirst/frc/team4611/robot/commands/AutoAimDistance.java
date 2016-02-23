package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoAimDistance extends Command {

    double[] centerY;
    double[] defaultValue = { -5.0, -5.0 };
    double testingDouble;
    double initialTime;
    double aimTimeMilli;
    double waitTimeMilli;
    double motorSpeed;
    double k = 0.002;

    public AutoAimDistance() {
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.requires(Robot.flipSolenoid);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //Turns the motors based on a proportion of the distance left to turn
        this.motorSpeed = this.k
                * Math.abs(this.testingDouble - RobotMap.centerYTarget) + 0.37;
        //Turns only the front two motors
        Robot.leftS.moveSingle(this.dirMoving() * this.motorSpeed);
        Robot.rightS.moveSingle(this.dirMoving() * this.motorSpeed);
    }

    //Outputs to SmartDashboard which way the bot is moving
    public int dirMoving() {
        try {
            this.centerY = Robot.table.getNumberArray("centerY",
                    this.defaultValue);
            this.testingDouble = this.centerY[0];
            if (this.testingDouble > (RobotMap.centerYTarget
                    + RobotMap.targetSpread)) {
                SmartDashboard.putString("Vision Auto Turn Status: ",
                        "Going back");
                return -1;
            } else if (this.testingDouble < (RobotMap.centerYTarget
                    - RobotMap.targetSpread)) {
                SmartDashboard.putString("Vision Auto Turn Status: ",
                        "Going forward");
                return 1;
            } else if ((this.testingDouble <= (RobotMap.centerYTarget
                    + RobotMap.targetSpread))
                    && (this.testingDouble >= (RobotMap.centerYTarget
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
            SmartDashboard.putString("Vision Auto Turn Status: ",
                    "Target not available");
            return 0;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return (this.testingDouble <= (RobotMap.centerYTarget
                + RobotMap.targetSpread))
                && (this.testingDouble >= (RobotMap.centerYTarget
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
                "Auto Adjust interrupted");
    }
}
