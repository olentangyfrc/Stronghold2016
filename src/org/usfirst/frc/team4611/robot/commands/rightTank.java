package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class rightTank extends Command {
	
	double joyVal;
	
    public rightTank() {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.rightS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	joyVal = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if(RobotMap.DirFaced)
    	//{
    		//joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY()) * -1;
    	//}
    	//else
    	//{
    		//joyVal = Robot.oi.filter(Robot.oi.RightJoy.getY());
    	//}
    	joyVal = Robot.oi.filter(Robot.oi.rightJoy.getY());
    	Robot.rightS.move(joyVal);
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
