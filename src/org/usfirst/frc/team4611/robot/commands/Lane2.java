package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Lane2 extends CommandGroup {

    public Lane2(Robot.Defense def) {
        switch (def) {
            case PORTCULLIS:
                this.addParallel(new FeedingPosition(), 7);
                this.addParallel(new ArmAuto(0.75), 1.25);
                Timer.delay(3);
                this.addParallel(new DriveAuto(0.3), 0.25);
                Timer.delay(.3);
                this.addParallel(new ArmAuto(-1), 1);
                this.addSequential(new DriveAuto(1), 0.5);
                break;
            case CHEVALDEFRISE:
                this.addSequential(new DriveAuto(0.3), 0.25);
                this.addParallel(new ArmAuto(0.75), 1.25);
                Timer.delay(3);
                this.addParallel(new DriveAuto(0.3), 0.25);
                Timer.delay(.3);
                this.addParallel(new ArmAuto(-1), 1);
                this.addSequential(new DriveAuto(1), 0.5);
                break;
            case ROCKWALL:
                this.addSequential(new DriveAuto(RobotMap.rockWallSpeed), 1);
                break;
            case MOAT:
                this.addSequential(new DriveAuto(RobotMap.moatSpeed), 1);
                break;
            case ROUGHTERRAIN:
                this.addSequential(new DriveAuto(RobotMap.roughTerrainSpeed),
                        0.75);
                break;
            case RAMPARTS:
                this.addSequential(new DriveAuto(RobotMap.rampartSpeed), 0.75);
                break;
        }
        this.addSequential(new AutonomousTurn(0.1, 1)); //don't give negative speed values STEP 2
        this.addParallel(new ShooterWheelsMove(0.5), 5); //STEP 3
        Timer.delay(0.5); //Number based on how long wheels take to spin up
        this.addParallel(new AutoAim(), 2);
        Timer.delay(2);
        this.addSequential(new FeedPush());
    }
}
