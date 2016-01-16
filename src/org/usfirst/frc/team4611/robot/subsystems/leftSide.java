package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
//import org.usfirst.frc.team4611.robot.commands.leftTank;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class leftSide extends Subsystem {
	private Victor frontL;
	private Victor backL;
	
	public leftSide()
	{
		frontL =  new Victor(0);
		backL = new Victor(1);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void move(double speed)
	{
		//speed = Math.signum(speed) * (Math.abs(speed) - .1);
		frontL.set(speed);
		backL.set(speed); 
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new leftTank());
    }
}