package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionShoot extends Command {
    double speed;

    public VisionShoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.speed = 0.5;
        this.requires(Robot.shooterWheels);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() { //should stop already running wheels too

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	///double 
    	double[] defaultValue = new double[0];
    	double[] centerX = Robot.table.getNumberArray("centerX", defaultValue);
    	double testingDouble = centerX[0];
    	if (testingDouble > 50) {
    		Robot.shooterWheels.shoot(this.speed);
    	} else if (testingDouble <=50 && testingDouble > 0) {
    		Robot.shooterWheels.shoot(-this.speed);
    	} else {
    		//Robot.shooterWheels.shoot(this.speed*.5);
    		System.out.println("sumthing wong");
    	}
        /*double data = SmartDashboard.getNumber("centerX", -5.0);
        String str = SmartDashboard.getString("centerX");
        if (data > 50) {
            Robot.shooterWheels.shoot(this.speed);
        } else if (str.length() > 0) {
        	Robot.shooterWheels.shoot(-this.speed);
        }*/
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.shooterWheels.shoot(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        this.end();
    }
}
