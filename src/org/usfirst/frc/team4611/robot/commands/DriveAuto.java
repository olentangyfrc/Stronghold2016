package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveAuto extends Command {

    public Timer timer;
    public double initialTime;
    public double actualTime;
    public double speed2;

    /**
     * Constructor with just time
     *
     * @param time
     *            Time Robot should move at with default speed
     */
    public DriveAuto(double time) { //now we can call how long we want it to run

        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.actualTime = time;
        this.speed2 = RobotMap.autoSpeed;
    }

    /**
     * Constructor using a time and motor speed
     *
     * @param time
     *            Time robot should move
     * @param speed
     *            Speed motors should move at
     */
    public DriveAuto(double time, double speed) {
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.actualTime = time;
        this.speed2 = speed;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.initialTime = Timer.getFPGATimestamp();
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
        Robot.leftS.move(-this.speed2);
        Robot.rightS.move(-this.speed2);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - this.initialTime > this.actualTime;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
