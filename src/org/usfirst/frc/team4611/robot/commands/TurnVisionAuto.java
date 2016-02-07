package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnVisionAuto extends Command {
    double speed;
    double[] centerX;
    double[] defaultValue = { -5.0, -5.0 };
    double testingDouble;

    public TurnVisionAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.speed = 0.5;
        this.requires(Robot.leftS);
        this.requires(Robot.rightS);
        this.requires(Robot.feedSolenoid);
        this.requires(Robot.flipSolenoid);
        this.requires(Robot.shooterWheels);
        //this.centerX = Robot.table.getNumberArray("centerX", this.defaultValue);
        //testingDouble = centerX[0];
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() { //should stop already running wheels too

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        ///double
        /*
         * double[] defaultValue = new double[0]; double[] centerX =
         * Robot.table.getNumberArray("centerX", defaultValue); double
         * testingDouble = centerX[0]; if (testingDouble > 50) {
         * Robot.shooterWheels.shoot(this.speed); } else if (testingDouble <=50
         * && testingDouble > 0) { Robot.shooterWheels.shoot(-this.speed); }
         * else { //Robot.shooterWheels.shoot(this.speed*.5);
         * System.out.println("sumthing wong"); }
         */
        this.centerX = Robot.table.getNumberArray("centerX", this.defaultValue);
        this.testingDouble = this.centerX[0];
        if (this.testingDouble > (RobotMap.centerXOfficial
                + RobotMap.targetSpread)) {
            Robot.leftS.move(-RobotMap.visionMotorSpeed);
            Robot.rightS.move(RobotMap.visionMotorSpeed);
        } else if (this.testingDouble < (RobotMap.centerXOfficial
                - RobotMap.targetSpread)) {
            Robot.leftS.move(RobotMap.visionMotorSpeed);
            Robot.rightS.move(-RobotMap.visionMotorSpeed);
        }
        //if (centerX > RobotMap.centerXOfficial + RobotMap.s) {

        //} else if () {

        //}
        /*
         * double data = SmartDashboard.getNumber("centerX", -5.0); String str =
         * SmartDashboard.getString("centerX"); if (data > 50) {
         * Robot.shooterWheels.shoot(this.speed); } else if (str.length() > 0) {
         * Robot.shooterWheels.shoot(-this.speed); }
         */
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        //Robot.shooterWheels.shoot(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        this.end();
    }
}
