package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SolenoidCommand extends Command {

    

    public SolenoidCommand() {
        this.requires(Robot.solenoidSubsystem);
        
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        //this.initialTime = this.timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.solenoidSubsystem.extend(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}
}
