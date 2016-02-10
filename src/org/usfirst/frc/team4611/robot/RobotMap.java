package org.usfirst.frc.team4611.robot;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int frontLeftWheel = 1;
    public static final int backLeftWheel = 2;
    public static final int frontRightWheel = 3;
    public static final int backRightWheel = 4;

    // Joystick  ports
    public static final int leftJS = 1;
    public static final int rightJS = 2;
    public static final int LAcSpeed = 1;

    public static final int solePort1 = 0;
    
    
    public static final int potPort = 1;
    public static final int clawMotorPort = 7;

    public static final double soleTime = 2.0;
    public static final double autoTime = 30;

    public static final int PORT = 0;
    
    public static final double autoSpeed = .5;

}
