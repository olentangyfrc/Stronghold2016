package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.SolenoidClose;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Solenoid 1 will be the flipping the mechanism Solenoid 2 will be the
 * launching pneumatic
 */
public class SolenoidSubsystem extends Subsystem {
    Solenoid s1;
    Solenoid s2;

    public SolenoidSubsystem() {
        super("Solenoid Subsystem");
        this.s1 = new Solenoid(RobotMap.solePort1);
        this.s2 = new Solenoid(RobotMap.solePort2);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void flip(boolean on) {
        this.s1.set(on);
    }

    public void feed(boolean on) {
        this.s2.set(on);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new SolenoidClose());
    }

}
