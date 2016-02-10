package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class GrabberClaw extends PIDSubsystem {
	public static Potentiometer pot;
	public static Victor clawMotor; //not sure if this is the right class, if it doesn't work try again with regular victor
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public GrabberClaw(/*double p, double i, double d*/) {
    	super ("Claw", 2.0, 0.0, 0.0);
    	AnalogInput ai = new AnalogInput(1);
    	pot = new AnalogPotentiometer(ai, .1, 0);
		clawMotor = new Victor(RobotMap.clawMotorPort);
		// TODO Auto-generated constructor stub
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public double returnPIDInput() {
		//TODO Auto-generated method stub
		return ((AnalogInput) pot).getAverageVoltage();
	}

	@Override
	public void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		clawMotor.set(output);
	}
}
