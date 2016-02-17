package org.usfirst.frc.team4611.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.ArmManual;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
	
public class SwivelArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Victor elevator;
	
	public SwivelArm() {
		elevator = new Victor(RobotMap.swivelMotorPort);
	}
	
	public void move(double speed) {
		elevator.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmManual());
    }
}

