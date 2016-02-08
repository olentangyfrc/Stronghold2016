package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
//Spy Bot Program
/**
 *
 */
public class autonomousCommandGroup2 extends CommandGroup {
    
    public  autonomousCommandGroup2() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	

    	//addSequential (new SolenoidCommand());
    	addSequential (new TurnAuto(0.0, -1,0.0 ));
    	addSequential (new DriveAuto(0.0,0.0)); // DriveAuto's have different length parameters
    	addSequential (new TurnAuto(0.0, -1, 0.0));
    	addSequential (new DriveAuto(0.0,0.0));
    	
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}