package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
//Low Bar start- go on front ramp, shoot boulder
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
    	int lane =0;//= Switchboard input
    	//int lane2=0;// 2nd switchboard input
    	switch (lane)
    	{
    	case 1:
    		lane=1; //Low Bar start- go on front ramp, shoot boulder
    		//Starts on neutral line facing enemy outerworks
    		addSequential (new DriveAuto(0.0, 0.0)); //1.2066 seconds for 10 ft. for Small Wheels
    		//Drives forward for an inputed speed and time
        	addSequential (new TurnAuto(0.0, 1, 0.0));//Turns right for an inputted speed and time
        	addSequential (new ShooterWheelsMove(0.5)); //input speed for how fast the wheels spin
        	addSequential (new AutoShooterSpinUp(0.5,5));// input speed and time for spinning the wheels up **at half power and 5 seconds
        	addParallel (new AutoShooterSol(1));// While wheels are spinning up, after an inputted speed the piston will fire **after 1 second
    		break;
    	case 2:
    		lane=2; //right now assume the robot drives over everything
    		addSequential (new DriveAuto(0.0, 0.0)); //1.2066 seconds for 10 ft. for Small Wheels
        	addSequential (new TurnAuto(0.0, 1, 0.0));
        	addSequential (new ShooterWheelsMove(0.5));
        	addSequential (new AutoShooterSpinUp(0.5,5));
        	addParallel (new AutoShooterSol(1));
    		break;
    	case 3:
    		lane=3;
    		addSequential (new DriveAuto(0.0, 0.0)); //1.2066 seconds for 10 ft. for Small Wheels
        	addSequential (new TurnAuto(0.0, 1, 0.0));
        	addSequential (new ShooterWheelsMove(0.5));
        	addSequential (new AutoShooterSpinUp(0.5,5));
        	addParallel (new AutoShooterSol(1));
    		break;
    	case 4:
    		lane=4;
    		addSequential (new DriveAuto(0.0, 0.0)); //1.2066 seconds for 10 ft. for Small Wheels
        	addSequential (new TurnAuto(0.0, -1, 0.0)); //turns left 
        	addSequential (new ShooterWheelsMove(0.5));
        	addSequential (new AutoShooterSpinUp(0.5,5));
        	addParallel (new AutoShooterSol(1));
    		break;
    	case 5:
    		lane=5;
    		addSequential (new DriveAuto(0.0, 0.0)); //1.2066 seconds for 10 ft. for Small Wheels
        	addSequential (new TurnAuto(0.0, -1, 0.0));
        	addSequential (new ShooterWheelsMove(0.5));
        	addSequential (new AutoShooterSpinUp(0.5,5));
        	addParallel (new AutoShooterSol(1));
    		break;
    	case 6: //SpyBot Case
    		lane=6;
    		addSequential (new ShooterWheelsMove(0.5));
        	addSequential (new AutoShooterSpinUp(0.5,5));
        	addParallel (new AutoShooterSol(1));//Shoots the ball
    		addSequential (new TurnAuto(0.0, 1,0.0 ));
        	addSequential (new DriveAuto(0.0,0.0)); // DriveAuto's have different length parameters
    		break;
    	}
    	//addSequential (new DriveAuto(0.0, 0.0)); //1.2066 seconds for 10 ft.
    	//addSequential (new TurnAuto(0.0, 1, 0.0)); //turns right, untested
    	//addSequential (new DriveAuto(.2, 0.5));
    	//addSequential (new TurnAuto(.2, -1, 0.5)); //turns left, untested
    	//addSequential (new DriveAuto (.7, 0.5));
    	//addSequential (new SolenoidCommand()); //Untested

    
    	
    	// A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
