package org.usfirst.frc.team4611.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static int frontLeftWheel = 0; //0
    public static int backLeftWheel = 1; //1
    public static int frontRightWheel = 2;
    public static int backRightWheel = 3; //3

    public static final int leftShooterWheel = 4;
    public static final int rightShooterWheel = 5;

    public static final double feedingWheelShooterSpeed = -0.3;
    public static final double launchingWheelShooterSpeed = .5;
    // Joystick  ports
    public static final int leftJS = 0;
    public static final int rightJS = 1;

    public static final int solePort1 = 3;
    public static final int solePort2 = 2;
    public static final int solePort3 = 1;
    public static final int solePort4 = 0;

    public static final double soleTime = 1.0;

    public static final int PORT = 0;

    public static int dirFacing = -1;

    public static double centerXOfficial = 300;
    
    public static double autoSpeed = .5;
}
