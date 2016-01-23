package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.FlipClose;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Solenoid 1 will be the flipping the mechanism
 */
public class FlipSolenoid extends Subsystem {
    DoubleSolenoid s1;

    public FlipSolenoid() {
        super("Flip Pneumatic");
        this.s1 = new DoubleSolenoid(RobotMap.solePort1, RobotMap.solePort2);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void flip(Value v) {
        this.s1.set(v);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new FlipClose());
    }

}
