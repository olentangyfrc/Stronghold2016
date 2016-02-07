package org.usfirst.frc.team4611.robot;

import org.usfirst.frc.team4611.robot.commands.FeedPush;
import org.usfirst.frc.team4611.robot.commands.FeedingPosition;
///import org.usfirst.frc.team4611.robot.commands.WheelReverse;
//import org.usfirst.frc.team4611.robot.commands.WheelShoot;
//import org.usfirst.frc.team4611.robot.commands.WheelsFeed;
import org.usfirst.frc.team4611.robot.commands.ShooterWheelsMove;
import org.usfirst.frc.team4611.robot.commands.TurnVisionAuto;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public Joystick leftJoy = new Joystick(1);
    public Joystick rightJoy = new Joystick(2);
    public Button pneumatic = new JoystickButton(this.rightJoy, 5);
    public AnalogInput ai = new AnalogInput(0);
    public Joystick shootJoy = new Joystick(3);

    //public Button feedingPneumatic = new JoystickButton(this.rightJoy, 5); // lowers the pneumatic
    public Button loadWheelsandFeeding = new JoystickButton(this.leftJoy, 4); // puts the wheels on reverse
    public Button shootWheels = new JoystickButton(this.shootJoy, 1); // puts the wheels on full forward
    //public Button combineLoading = new JoystickButton(this.rightJoy, 6); // executing both wheels and pnuematics to load
    //public Button shootingPneumatic = new JoystickButton(this.rightJoy, 4);
    public Button feedBall = new JoystickButton(this.rightJoy, 1); //moves the small pneumatic pusher
    public Button lowBar = new JoystickButton(this.leftJoy, 5);
    public Button aimAuto = new JoystickButton(this.rightJoy, 10);
    //public Button reverse = new JoystickButton (this.rightJoy, 8);//changes the orientation

    public OI() {
        //Button wheelShoot = new JoystickButton(this.leftJoy, 1);
        //Button wheelReverse = new JoystickButton(this.leftJoy, 2);

        //this.feedingPneumatic.whileHeld(new FeedingPosition());
        //this.shootingPneumatic.whenPressed(new ShootingPosition());
        this.loadWheelsandFeeding.whileHeld(
                new ShooterWheelsMove(RobotMap.feedingWheelShooterSpeed));
        this.loadWheelsandFeeding.whileHeld(new FeedingPosition());

        this.lowBar.whileHeld(
                new ShooterWheelsMove(0.0 * RobotMap.feedingWheelShooterSpeed)); //doesn't spin wheels at all. Change coefficient as needed.
        this.lowBar.whileHeld(new FeedingPosition());

        this.shootWheels.whileHeld(
                new ShooterWheelsMove(RobotMap.launchingWheelShooterSpeed));

        this.feedBall.whenPressed(new FeedPush());
        this.aimAuto.whileHeld(new TurnVisionAuto());
        //this.reverse.whenPressed(new ToggleCommand());
        //this.combineLoading.whileHeld(
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
            return 1 * (0.5 * Math.pow(raw, 3) + ((1 - .5) * raw)) / 1.7;
        }
    }

}
