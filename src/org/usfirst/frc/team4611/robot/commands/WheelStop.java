package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.subsystems.WheelShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WheelStop extends Command {

    private WheelShooter wheels;

    public WheelStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.wheelShooter);
        this.wheels = new WheelShooter();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        this.wheels.spin(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        this.wheels.spin(0);
    }
}
