package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.FeedClose;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Solenoid 2 will be the feeding the ball into the wheels
 */
public class FeedSolenoid extends Subsystem {
    DoubleSolenoid s2;

    public FeedSolenoid() {
        super("Feeding Pneumatic");
        this.s2 = new DoubleSolenoid(RobotMap.solePort3, RobotMap.solePort4);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void feed(Value v) {
        this.s2.set(v);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new FeedClose());
    }

}
