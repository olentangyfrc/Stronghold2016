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
		frontR = new Victor(RobotMap.frontRightWheel);
		backR = new Victor(RobotMap.backRightWheel);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void move(double speed)
	{
		//speed = Math.signum(speed) * (Math.abs(speed) - .1);
		frontR.set(-speed*RobotMap.dirFacing);
		backR.set(-speed*RobotMap.dirFacing);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new rightTank());
    	
    }
}

