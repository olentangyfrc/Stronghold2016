package org.usfirst.frc.team4611.robot.commands;
import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmManual extends Command {

    public ArmManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.swivelArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.enableArm.get()) {
	    	double joyVal = (Robot.oi.shootJoy.getY()*RobotMap.maxSwivelSpeed);
	    	if ((joyVal > 0)&&Robot.oi.swivelTopLimit.get()) {
	    		Robot.swivelArm.move(joyVal);
	    	} else if ((joyVal < 0)&&Robot.oi.swivelBottomLimit.get()) {
	    		Robot.swivelArm.move(joyVal);
	    	} else {
	    		
	    	}
    	}
    }
    
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
