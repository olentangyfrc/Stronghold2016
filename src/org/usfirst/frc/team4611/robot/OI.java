package org.usfirst.frc.team4611.robot;

import org.usfirst.frc.team4611.robot.commands.ArmAuto;
import org.usfirst.frc.team4611.robot.commands.FeedPush;
import org.usfirst.frc.team4611.robot.commands.FeedingPosition;
///import org.usfirst.frc.team4611.robot.commands.WheelReverse;
//import org.usfirst.frc.team4611.robot.commands.WheelShoot;
//import org.usfirst.frc.team4611.robot.commands.WheelsFeed;
import org.usfirst.frc.team4611.robot.commands.ShooterWheelsMove;
import org.usfirst.frc.team4611.robot.commands.AutoAim;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static Relay spike = new Relay(RobotMap.spikePort,Direction.kForward);
            //INSTANTIATING JOYSTICKS AND BUTTONS:

    //Driver Station joysticks
    public Joystick leftJoy = new Joystick(1);
    public Joystick rightJoy = new Joystick(2);
    public Joystick shootJoy = new Joystick(3);

    public Button loadWheelsandFeeding = new JoystickButton(this.leftJoy, 4);// puts the wheels on reverse
    public Button loadWheelsandFeedingShootJoy = new JoystickButton(this.shootJoy, 4);
    public Button shootWheels = new JoystickButton(this.shootJoy, 1); // puts the wheels on full forward
    public Button feedBall = new JoystickButton(this.rightJoy, 1); //moves the small pneumatic pusher
    public Button lowBar = new JoystickButton(this.leftJoy, 5);
    public Button aimAuto = new JoystickButton(this.rightJoy, 10);
    public Button lowerArm = new JoystickButton(this.shootJoy, 3);
    public Button raiseArm = new JoystickButton(this.shootJoy, 4);
    //public Button reverse = new JoystickButton (this.rightJoy, 8);//changes the orientation
    public DigitalInput swivelTopLimit = new DigitalInput(RobotMap.topLimit);
    public DigitalInput swivelBottomLimit = new DigitalInput(RobotMap.bottomLimit);
    
    public OI() {
        //Runs the wheels backwards while the wheel shooter is down WHILEHELD
        if (this.shootWheels.get()) {
    		this.loadWheelsandFeeding.whileHeld(
                new ShooterWheelsMove(RobotMap.launchingWheelShooterSpeed));
    		this.loadWheelsandFeedingShootJoy.whileHeld(
                    new ShooterWheelsMove(RobotMap.launchingWheelShooterSpeed));
        } else {
        	this.loadWheelsandFeeding.whileHeld(
                    new ShooterWheelsMove(RobotMap.feedingWheelShooterSpeed));
        	this.loadWheelsandFeedingShootJoy.whileHeld(
                    new ShooterWheelsMove(RobotMap.feedingWheelShooterSpeed));
        }
        this.loadWheelsandFeeding.whileHeld(new FeedingPosition());
        
        
        this.loadWheelsandFeedingShootJoy.whileHeld(new FeedingPosition());

        //Stops the wheels and lowers shooter while going under low bar WHILEHELD
        this.lowBar.whileHeld(
                new ShooterWheelsMove(0.0 * RobotMap.feedingWheelShooterSpeed)); //doesn't spin wheels at all. Change coefficient as needed.
        this.lowBar.whileHeld(new FeedingPosition());

        
        //Spins up the wheels WHILEHELD
        this.shootWheels.whileHeld(
                new ShooterWheelsMove(RobotMap.launchingWheelShooterSpeed));

        //Fires solenoid to shoot the ball WHENPRESSED
        this.feedBall.whenPressed(new FeedPush());

        //Auto-aim according the vision WHILEHELD
        this.aimAuto.whileHeld(new AutoAim());

        this.lowerArm.whenPressed(new ArmAuto(false));
        this.raiseArm.whenPressed(new ArmAuto(true));
        //this.reverse.whenPressed(new ToggleCommand());
        //new ShooterWheelsMove(RobotMap.feedingWheelShooterSpeed));//not sure if this will work
        //this.combineLoading.whenPressed(new FeedingPosition()); //not sure if this will work
        //wheelShoot.whenPressed(new WheelShoot());
        //wheelReverse.whileHeld(new WheelReverse());
    }

    public double filter(double raw) //used to cut interference
    {
        if (Math.abs(raw) < .15) {
            return 0;
        } else {
            return .8 * (0.5 * Math.pow(raw, 3) + ((1 - .5) * raw));
        }
    }

}
