package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterWheels extends Subsystem {
    private Victor left;
    private Victor right;

    public ShooterWheels() {
        this.left = new Victor(RobotMap.leftShooterWheel);
        this.right = new Victor(RobotMap.rightShooterWheel);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void shoot(double speed) {
        this.left.set(speed);
        this.right.set(-speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
