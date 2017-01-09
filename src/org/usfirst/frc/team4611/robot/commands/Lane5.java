package org.usfirst.frc.team4611.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Lane5 extends CommandGroup {

    public Lane5(Robot.Defense def) {
        switch (def) {
            case PORTCULLIS:
                this.addParallel(new FeedingPosition(), 7);
                this.addParallel(new ArmAuto(0.75), 1.25);
                delay(3);
                this.addParallel(new DriveAuto(0.3), 0.25);
                delay(.3);
                this.addParallel(new ArmAuto(-1), 1);
                this.addSequential(new DriveAuto(1), 0.5);
                break;
            case CHEVALDEFRISE:
                this.addSequential(new DriveAuto(0.3), 0.25);
                this.addParallel(new ArmAuto(0.75), 1.25);
                delay(3);
                this.addParallel(new DriveAuto(0.3), 0.25);
                delay(.3);
                this.addParallel(new ArmAuto(-1), 1);
                this.addSequential(new DriveAuto(1), 0.5);
                break;
            case ROCKWALL:
                this.addSequential(new DriveAuto(RobotMap.rockWallSpeed),
                        RobotMap.rockWallTime);
                break;
            case MOAT:
                this.addSequential(new DriveAuto(RobotMap.moatSpeed),
                        RobotMap.moatTime);
                break;
            case ROUGHTERRAIN:
                this.addSequential(new DriveAuto(RobotMap.roughTerrainSpeed),
                        RobotMap.roughTerrainTime);
                break;
            case RAMPARTS:
                this.addSequential(new DriveAuto(RobotMap.rampartSpeed),
                        RobotMap.rampartTime);
                break;
        }
    }
    public void delay(double seconds) {
    	double initial = Timer.getFPGATimestamp();
    	while (Timer.getFPGATimestamp() - initial > seconds) {}
    	return;
    }
}
