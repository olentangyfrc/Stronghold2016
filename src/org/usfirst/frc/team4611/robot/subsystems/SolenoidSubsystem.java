package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidSubsystem extends Subsystem {
    Solenoid s1;

    public SolenoidSubsystem() {
        super("Solenoid Subsystem");
        this.s1 = new Solenoid(RobotMap.solePort1);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void extend(boolean on) {
        this.s1.set(on);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}
