package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootingPosition extends Command {

    public double initialTime;
    public Timer timer;

    public ShootingPosition() {
        this.requires(Robot.flipSolenoid);
        this.timer = new Timer();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.initialTime = this.timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.flipSolenoid.flip(Value.kReverse);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return this.timer.getFPGATimestamp()
                - this.initialTime > RobotMap.soleTime;
    }

    // Called once after isFinished returns true

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

    @Override
    protected void end() {
        Robot.flipSolenoid.flip(Value.kOff);
    }
}
