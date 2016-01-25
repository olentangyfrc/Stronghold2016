package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FeedPush extends Command {

	public double initialTime;
    public Timer timer;
    
    public FeedPush() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.requires(Robot.shooterWheels);
    	this.timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.initialTime = this.timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (this.timer.getFPGATimestamp()
                - this.initialTime < RobotMap.soleTime) {
            Robot.feedSolenoid.feed(Value.kForward);
        } else {
            Robot.feedSolenoid.feed(Value.kOff);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return this.timer.getFPGATimestamp()
                - this.initialTime > RobotMap.soleTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.feedSolenoid.feed(Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
