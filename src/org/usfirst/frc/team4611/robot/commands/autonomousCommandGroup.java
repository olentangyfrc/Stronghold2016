package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autonomousCommandGroup extends CommandGroup {
    
    public  autonomousCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel
    	
    	//The following two lines are examples
    	addSequential(new DriveAuto(.7));
    	addSequential (new TurnAuto(.2, 1)); //turns one way
    	addSequential (new DriveAuto(.2));
    	addSequential (new TurnAuto(.2, -1)); //turns the other way
    	addSequential (new DriveAuto (.7));
    	addSequential (new SolenoidCommand()); //check to see if this works. It might work, it might not.
    	
    	// A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
