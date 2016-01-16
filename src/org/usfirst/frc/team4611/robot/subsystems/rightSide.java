package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.rightTank;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
/**
 *
 */
public class rightSide extends Subsystem {
	private Victor frontR;
	private Victor backR;
	public rightSide()
	{
		frontR = new Victor(2);
		backR = new Victor(3);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void move(double speed)
	{
		//speed = Math.signum(speed) * (Math.abs(speed) - .1);
		frontR.set(-speed);
		backR.set(-speed);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new rightTank());
    	
    }
}

