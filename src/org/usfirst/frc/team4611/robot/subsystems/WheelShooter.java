package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WheelShooter extends Subsystem {
    private Victor leftW;
    private Victor rightW;

    public WheelShooter() {
        super("Wheel Shooter");
        this.leftW = new Victor(RobotMap.leftWheelShooter);
        this.rightW = new Victor(RobotMap.rightWheelShooter);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void spin(double speed) {
        //speed = Math.signum(speed) * (Math.abs(speed) - .1);
        this.leftW.set(speed);
        this.rightW.set(-speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new leftTank());
    }
}
