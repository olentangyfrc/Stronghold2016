package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionPulse extends Command {

    private int caseNumber;
    private int direction;
    private double currentX;
    private double absDiff;
    private double time;

    private double[] centerX;
    private double[] lengths = { 0, RobotMap.targetSpread, 25, 25, 50, 90,
            110 };
    private double[] speeds = { 0, 0.3, 0.3, 0.3, 0.4, 0.5, 0.8 };
    private double[] times = { 0.1, 0.3, 0.5, 0.6, 0.7, 0.8, 1 };
    private double[] defaultValue = { -5.0, -5.0 };

    public VisionPulse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        this.time = Timer.getFPGATimestamp();

        this.centerX = Robot.table.getNumberArray("centerX", this.defaultValue);
        this.currentX = this.centerX[0];
        this.absDiff = Math.abs(this.currentX - RobotMap.centerXTarget);

        if (this.currentX > RobotMap.centerXTarget) {
            this.direction = -1;
        } else {
            this.direction = 1;
        }

        for (int i = this.lengths.length - 1; i >= 0; i--) {
            if (this.absDiff > this.sumArray(this.lengths, i)) {
                this.caseNumber = i;
                break;
            }
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.leftS.move(this.direction * this.speeds[this.caseNumber]);
        Robot.rightS.move(-this.direction * this.speeds[this.caseNumber]);
    }

    private double sumArray(double[] arr, int lim) {
        double sum = 0;
        for (int i = 0; i < lim; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Timer.getFPGATimestamp()
                - this.time < this.times[this.caseNumber]
                || this.caseNumber == 0;
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
