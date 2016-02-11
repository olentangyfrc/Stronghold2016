package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionAutoGroup extends CommandGroup {
    double initialTime;
    double speed;
    double testingDouble;
    double[] centerXdata;
    
    public  VisionAutoGroup() {
    	this.speed = 0.5;
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.requires(Robot.feedSolenoid);
        this.requires(Robot.flipSolenoid);
        this.requires(Robot.shooterWheels);
        /*while (true) {
        	double[] defaultValue = {-5.0, -5.0};
        	double timeDifferenceMilli = (Timer.getFPGATimestamp() - initialTime) * 1000;
        	if (timeDifferenceMilli % (RobotMap.aimTimeMilli + RobotMap.waitTimeMilli) < RobotMap.aimTimeMilli) {
        		centerXdata = Robot.table.getNumberArray("centerX", defaultValue);
		        testingDouble = centerXdata[0];
		        if (Double.compare(this.testingDouble, defaultValue[0]) == 0) {
		        	System.out.println("There is no vision being inputted");
		        	SmartDashboard.putString("Vision Auto Turn Status: ", "There is no vision being inputted");
		        } else if (this.testingDouble > (RobotMap.centerXOfficial + RobotMap.targetSpread)) {
		            Robot.leftS.move(-RobotMap.visionMotorSpeed);
		            Robot.rightS.move(RobotMap.visionMotorSpeed);
		            System.out.println("You should be turning left");
		            SmartDashboard.putString("Vision Auto Turn Status: ", "You should be turning left");
		        } else if ((this.testingDouble < (RobotMap.centerXOfficial - RobotMap.targetSpread) && this.testingDouble>0.0)) {
		            Robot.leftS.move(RobotMap.visionMotorSpeed);
		            Robot.rightS.move(-RobotMap.visionMotorSpeed);
		            System.out.println("You should be turning right");
		            SmartDashboard.putString("Vision Auto Turn Status: ", "You should be turning right");
		        } else {
		        	System.out.println("You should be doing nothing");
		        	SmartDashboard.putString("Vision Auto Turn Status: ", "You should be doing nothing");
		        }
    		} else {
    			SmartDashboard.putString("Vision Auto Turn Status: ", "You should be waiting");
    		}
        	
        }*/
    }
    
    public void initialize() {
    	initialTime = Timer.getFPGATimestamp();
    }
    
    public void interrupted() {
    	
    }
}
