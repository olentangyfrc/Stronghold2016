package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Lane2 extends CommandGroup {

    public Lane2(Robot.Defense def) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
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
        this.addSequential(new AutonomousTurn(0.0, 1, 0.0)); //don't give negative speed values
        this.addParallel(new ShooterWheelsMove(0.5), 5);
        Timer.delay(2.5); //Number based on how long wheels take to spin up
        this.addSequential(new FeedPush());
    }
}
