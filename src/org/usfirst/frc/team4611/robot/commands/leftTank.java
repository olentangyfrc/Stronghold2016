package org.usfirst.frc.team4611.robot.commands;

import java.io.FileOutputStream;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class leftTank extends Command {

    double joyVal;
    public Timer timer;
    public double initialTime;
    FileOutputStream out;

    public leftTank() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.leftS);
        this.initialTime = this.timer.getFPGATimestamp();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.joyVal = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
<<<<<<< HEAD
        //if(RobotMap.DirFaced)
        //{
        //joyVal = Robot.oi.filter(Robot.oi.RightJoy.getY()) * -1;
        //}
        //else
        //{
        //joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());
        //}
        this.joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());
        Robot.leftS.move(this.joyVal);

        /*
         * for (String key : Robot.visionTable.getKeys()) { double[] data =
         * Robot.visionTable.getNumberArray(key, defaultValue); for (int i = 1;
         * i <= data.length; i++) { SmartDashboard.putNumber(key + " #" + i,
         * data[i]); } }
         */
        //double value = Robot.oi.ai.getAverageValue();
        //double distance = (value * 0.49) / 100;
        //SmartDashboard.putNumber("Range Finder Average Voltage", value);
        //SmartDashboard.putNumber("Calculated Distance", distance);
=======
    	//if (RobotMap.dirFacing == 1) {
    		joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());
    		//RobotMap.frontLeftWheel = 2;
    		//RobotMap.backLeftWheel = 7;
    		//RobotMap.frontRightWheel = 8;
    		//RobotMap.backRightWheel = 9;
    	//} else if (RobotMap.dirFacing == -1) {
    		//joyVal = Robot.oi.filter(Robot.oi.rightJoy.getY());
    		//RobotMap.frontLeftWheel = 8;
    		//RobotMap.backLeftWheel = 9;
    		//RobotMap.frontRightWheel = 2;
    		//RobotMap.backRightWheel = 7;
    	//}
    	Robot.leftS.move(joyVal);
>>>>>>> 736200bad486ca866d484dbf39fc0ae762fd25e9
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
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
