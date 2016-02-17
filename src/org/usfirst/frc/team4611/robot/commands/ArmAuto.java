package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmAuto extends Command {

	public boolean upOrDown; //true is up, false is down
    public ArmAuto(boolean input) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.swivelArm);
    	upOrDown = input;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!Robot.oi.swivelTopLimit.get()&&upOrDown) {
    		Robot.swivelArm.move(RobotMap.maxSwivelSpeed);
    	} else if (!Robot.oi.swivelBottomLimit.get()&&!upOrDown) {
    		Robot.swivelArm.move(-RobotMap.maxSwivelSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (upOrDown) {
    		return Robot.oi.swivelTopLimit.get();
    	} else if (!upOrDown) {
    		return Robot.oi.swivelBottomLimit.get();
    	} else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
