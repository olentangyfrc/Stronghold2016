package org.usfirst.frc.team4611.robot.subsystems;

//import org.usfirst.frc.team4611.robot.commands.leftTank;
import org.usfirst.frc.team4611.robot.commands.leftTank;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class leftSide extends Subsystem {
    private Victor frontL;
    private Victor backL;

    public leftSide() {
        this.frontL = new Victor(0);
        this.backL = new Victor(1);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void move(double speed) {
        //speed = Math.signum(speed) * (Math.abs(speed) - .1);
        this.frontL.set(speed);
        this.backL.set(speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.setDefaultCommand(new leftTank());
    }
}