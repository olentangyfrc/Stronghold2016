package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmAuto extends Command {

    public boolean upOrDown; //true is up, false is down

    public ArmAuto(boolean input) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.swivelArm);
        this.upOrDown = input;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (!Robot.oi.swivelTopLimit.get() && this.upOrDown) {
            Robot.swivelArm.move(RobotMap.maxSwivelSpeed);
        } else if (!Robot.oi.swivelBottomLimit.get() && !this.upOrDown) {
            Robot.swivelArm.move(-RobotMap.maxSwivelSpeed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (this.upOrDown) {
            return Robot.oi.swivelTopLimit.get();
        } else if (!this.upOrDown) {
            return Robot.oi.swivelBottomLimit.get();
        } else {
            return true;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.swivelArm.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        this.end();
    }
}
