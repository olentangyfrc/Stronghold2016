package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousTurn extends Command {
    public int turningOrientation;
    public double speed2;
    private double[] centerXs;

    /**
     * Constructor for turning at default speed
     *
     * @param time
     *            Amount of time turn will be executed
     * @param turning
     *            LEFT is -1 RIGHT is 1
     */
    public AutonomousTurn(int turning) { //now we can call how long we want it to turn, and in what direction
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.turningOrientation = turning; //this should only be 1 or -1; if it's 0,  the robot won't move.
        this.speed2 = RobotMap.autoTurnSpeed;
    }

    /**
     * Constructor for turning during autonomous period
     *
     * @param time
     *            Amount of time turn is executed
     * @param turning
     *            LEFT is -1 RIGHT is 1
     * @param speed
     *            Speed turn is executed
     */
    public AutonomousTurn(double time, int turning, double speed) {
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.turningOrientation = turning;
        this.speed2 = speed;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //if(RobotMap.DirFaced)
        //{
        //joyVal = Robot.oi.filter(Robot.oi.RightJoy.getY()) * -1;
        //}
        //else
        //{
        //joyVal = Robot.oi.filter(Robot.oi.leftJoy.getY());
        //}
        Robot.leftS.move(this.turningOrientation * this.speed2);
        Robot.rightS.move(-this.turningOrientation * this.speed2);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
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
}
