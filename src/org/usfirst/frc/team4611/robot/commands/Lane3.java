package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Lane3 extends CommandGroup {

    public Lane3(Robot.Defense def) {
        switch (def) {
            case PORTCULLIS:
                this.addSequential(new DriveAuto(1, 0.3));
                this.addParallel(new ArmAuto(true), 3);
                this.addSequential(new DriveAuto(4, 0.7));
                break;
            case CHEVALDEFRISE:
                this.addSequential(new DriveAuto(1, 0.3));
                this.addParallel(new ArmAuto(false), 0.5);
                this.addSequential(new DriveAuto(4, 0.6));
                break;
            case DRIVE:
                this.addSequential(new DriveAuto(5, 0.8));
                break;
        }
        this.addParallel(new ShooterWheelsMove(0.5), 5);
        Timer.delay(2.5); //Number based on how long wheels take to spin up
        this.addSequential(new FeedPush());

    }
}
