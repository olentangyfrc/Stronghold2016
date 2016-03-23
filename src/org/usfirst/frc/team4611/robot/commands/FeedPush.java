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
    public double delay = 0;

    public FeedPush() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.feedSolenoid);
    }
    
    public FeedPush(double delay) {
    	this.delay=delay;
    	this.requires(Robot.feedSolenoid);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.initialTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (Timer.getFPGATimestamp() - this.initialTime > delay) {
    		Robot.feedSolenoid.feed(Value.kForward);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - this.initialTime > (RobotMap.soleTime+this.delay);
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.feedSolenoid.feed(Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        this.end();
    }
}
