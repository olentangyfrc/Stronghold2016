package org.usfirst.frc.team4611.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.TurnVisionAuto;
import org.usfirst.frc.team4611.robot.commands.rightTank;
/**
 *
 */
	
public class VisionTank extends Subsystem {
	private Victor left;
	private Victor right;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public VisionTank() {
		left = new Victor(RobotMap.backLeftWheel);
		right = new Victor(RobotMap.backRightWheel);
	}
	public void move(double speed) {
		left.set(speed);
		right.set(-speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TurnVisionAuto());
    }
}

