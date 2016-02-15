package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class VisionPID extends PIDCommand {

    public VisionPID() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("PID Vision Controller Command", 1, 0, 0);
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.getPIDController().setOutputRange(0.2, 0.45);
        this.getPIDController().setContinuous();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.getPIDController().enable();
        this.getPIDController().setAbsoluteTolerance(RobotMap.targetSpread);
        super.setSetpoint(RobotMap.centerXTarget);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return this.getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.leftS.move(0);
        Robot.rightS.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        this.end();
    }

    @Override
    protected double returnPIDInput() {
        // TODO Auto-generated method stub
        double[] defaultValue = { 0, 0 };
        double[] centerX = Robot.table.getNumberArray("centerX", defaultValue);
        return centerX[0];
    }

    @Override
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub
        Robot.leftS.move(output);
        Robot.rightS.move(-output);
    }

    public PIDController getPIDControl() {
        return this.getPIDController();
    }
}