package org.usfirst.frc.team4611.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBar extends CommandGroup {

    public LowBar() {
        this.addParallel(new FeedingPosition(), 7);
        delay(3);
        this.addSequential(new DriveAuto(0.5), 2.5);
        this.addSequential(new AutonomousTurn(1), 0.3); //don't give negative speed values

        this.addParallel(new ShooterWheelsMove(0.5), 5); //STEP 3
        delay(0.5); //Number based on how long wheels take to spin up
        this.addParallel(new AutoAim(), RobotMap.aimTime);
        delay(1.5);
        /*double initialTime = Timer.getFPGATimestamp();
        ArrayList<Double> values = new ArrayList<Double>();
        double[] defaultValue = { 0.0, 0.0 };
        double[] centerY;
        int counter = 0;
        while (Timer.getFPGATimestamp() - initialTime > 0.5) {
            delay(0.02);
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
        }*/
        this.addSequential(new FeedPush());
    }
    
    public void delay(double seconds) {
    	double initial = Timer.getFPGATimestamp();
    	while (Timer.getFPGATimestamp() - initial > seconds) {}
    	return;
    }
}
