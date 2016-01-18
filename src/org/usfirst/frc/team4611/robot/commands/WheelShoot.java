package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.subsystems.WheelShooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WheelShoot extends Command {

    private WheelShooter wheels;
    private Timer timer;
    private double initialTime;

    public WheelShoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.wheelShooter);
        this.wheels = new WheelShooter();
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
        this.wheels.spin(RobotMap.wheelForwardSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return this.timer.getFPGATimestamp()
                - this.initialTime > RobotMap.shootTime;
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
