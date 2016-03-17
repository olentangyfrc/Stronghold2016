package org.usfirst.frc.team4611.robot.commands;

import java.util.ArrayList;

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
        this.addSequential(new AutonomousTurn(1), 0.2); //don't give negative speed values STEP 2
        this.addParallel(new ShooterWheelsMove(0.5), 5); //STEP 3
        Timer.delay(0.5); //Number based on how long wheels take to spin up
        this.addParallel(new AutoAim(), 2);
        Timer.delay(2);
        double initialTime = Timer.getFPGATimestamp();
        ArrayList<Double> values = new ArrayList<Double>();
        double[] defaultValue = { 0.0, 0.0 };
        double[] centerY;
        int counter = 0;
        while (Timer.getFPGATimestamp() - initialTime > 0.5) {
            Timer.delay(0.02);
            try {
                centerY = Robot.table.getNumberArray("centerY", defaultValue);
                values.add(centerY[0]);
                counter++;
            } catch (Exception e) {
                counter--;
            }
        }
        if (counter > 5) {
            double sum = 0;
            for (int x = 0; x < values.size(); x++) {
                sum += values.get(x);
            }
            sum /= values.size();
            if (sum < RobotMap.centerYLimit) {
                this.addSequential(new FeedPush());
            }
        }

    }
}
