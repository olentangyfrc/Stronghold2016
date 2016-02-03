package org.usfirst.frc.team4611.robot.commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        double value = Robot.oi.ai.getAverageValue();
        double distance = (value * 0.49) / 100;
        SmartDashboard.putNumber("Range Finder Average Voltage", value);
        SmartDashboard.putNumber("Calculated Distance", distance);
        
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
