package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBar extends CommandGroup {

    public LowBar() {
        this.addParallel(new ArmAuto(false), 1);
        this.addSequential(new FeedingPosition(), 1);
        this.addSequential(new DriveAuto(0.0, 0.0));
        this.addSequential(new ShootingPosition(), 1);
        this.addSequential(new AutonomousTurn(0.0, 1, 0.0)); //don't give negative speed values
        this.addParallel(new ShooterWheelsMove(0.5), 5);
        Timer.delay(2.5); //There is a specific amount of time for wheels to spin up
        this.addSequential(new FeedPush());
    }
}
