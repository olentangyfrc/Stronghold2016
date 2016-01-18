package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidSubsystem extends Subsystem {
    DoubleSolenoid s1 = new DoubleSolenoid(RobotMap.solePort1,
            RobotMap.solePort2);
    DoubleSolenoid s2 = new DoubleSolenoid(RobotMap.solePort3,
            RobotMap.solePort4);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void extendFeeder() {
        this.s1.set(Value.kForward);
    }

    public void retractFeeder() {
        this.s1.set(Value.kReverse);
    }

    public void extendAim() {
        this.s2.set(Value.kForward);
    }

    public void retractAim() {
        this.s2.set(Value.kReverse);
    }
}
