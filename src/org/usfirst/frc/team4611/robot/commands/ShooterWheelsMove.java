package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterWheelsMove extends Command {

    double speed;

    public ShooterWheelsMove(double inputSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.speed = inputSpeed;
        this.requires(Robot.shooterWheels);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() { //should stop already running wheels too
        OI.spike.set(Value.kOn);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.shooterWheels.shoot(this.speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.shooterWheels.shoot(0);
        OI.spike.set(Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        this.end();
    }
}
