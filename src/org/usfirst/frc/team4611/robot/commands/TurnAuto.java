package org.usfirst.frc.team4611.robot.commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnAuto extends Command {

    public Timer timer;
    public double initialTime;
    public double actualTime;
    public int turningOrientation;

    public TurnAuto(double time, int turning) { //now we can call how long we want it to turn, and in what direction
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.actualTime = time;
        this.turningOrientation = turning; //this should only be 1 or -1; if it's 0,  the robot won't move.
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.initialTime = Timer.getFPGATimestamp();
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
        Robot.leftS.move(turningOrientation*RobotMap.autoSpeed);
        Robot.rightS.move(-turningOrientation*RobotMap.autoSpeed);
        //double value = Robot.oi.ai.getAverageValue();
        //double distance = (value * 0.49) / 100;
        //SmartDashboard.putNumber("Range Finder Average Voltage", value);
        //SmartDashboard.putNumber("Calculated Distance", distance);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	return Timer.getFPGATimestamp() - initialTime > actualTime;    
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
