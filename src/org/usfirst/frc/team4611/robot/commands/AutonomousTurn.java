package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousTurn extends Command {

    public Timer timer;
    public double initialTime;
    public double actualTime;
    public int turningOrientation;
    public double speed2;
    private double[] centerXs;

    public AutonomousTurn(double time, int turning) { //now we can call how long we want it to turn, and in what direction
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.actualTime = time;
        this.turningOrientation = turning; //this should only be 1 or -1; if it's 0,  the robot won't move.
        this.speed2 = RobotMap.autoSpeed;
    }

    public AutonomousTurn(double time, int turning, double speed) {
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.actualTime = time;
        this.turningOrientation = turning;
        this.speed2 = speed;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.initialTime = Timer.getFPGATimestamp();
        OI.spike.set(Value.kOn);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //if(RobotMap.DirFaced)
        //{
        //joyVal = Robot.oi.filter(Robot.oi.RightJoy.getY()) * -1;
        //}
        //else
        //{
        //joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());
        //}
        Robot.leftS.move(this.turningOrientation * this.speed2);
        Robot.rightS.move(-this.turningOrientation * this.speed2);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        try {
            double[] defaultValue = { -5.0, -5.0 };
            this.centerXs = Robot.table.getNumberArray("centerX", defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Timer.getFPGATimestamp() - this.initialTime > this.actualTime
                || this.centerXs.length > 0;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
