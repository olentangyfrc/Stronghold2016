package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShooterSpinUp extends Command {
	
	 public double initialTime;
	 public Timer timer;
	 double speed;
	 public double actualTime;
	 
    public AutoShooterSpinUp(double inputSpeed, int inputTime) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.initialTime = this.timer.getFPGATimestamp();
    	speed = inputSpeed;
    	this.actualTime= inputTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterWheels.shoot(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Timer.getFPGATimestamp() - initialTime > actualTime;  
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
