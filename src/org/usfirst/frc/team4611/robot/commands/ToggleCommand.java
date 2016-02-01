package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4611.robot.RobotMap;

/**
 *
 */
public class ToggleCommand extends Command {

    public ToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.dirFacing == 1) {
    		RobotMap.dirFacing = -1;
    		RobotMap.frontLeftWheel = 2;
    		RobotMap.backLeftWheel = 7;
    		RobotMap.frontRightWheel = 8;
    		RobotMap.backRightWheel = 9;
    	} else if (RobotMap.dirFacing == -1) {
    		RobotMap.dirFacing = 1;
    		RobotMap.frontLeftWheel = 8;
    		RobotMap.backLeftWheel = 9;
    		RobotMap.frontRightWheel = 2;
    		RobotMap.backRightWheel = 7;
    	} else {
    		
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {//so that it only runs once
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
