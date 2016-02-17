package org.usfirst.frc.team4611.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //Drive train ports
    public static int frontLeftWheel = 0;
    public static int backLeftWheel = 1;
    public static int frontRightWheel = 2;
    public static int backRightWheel = 3;

    //Wheel shooter ports
    public static final int leftShooterWheel = 4;
    public static final int rightShooterWheel = 5;

    //Wheel shooter speeds
    public static final double feedingWheelShooterSpeed = -0.3;
    public static final double launchingWheelShooterSpeed = .5;

    //Solenoid ports
    public static final int solePort1 = 3;
    public static final int solePort2 = 2;
    public static final int solePort3 = 1;
    public static final int solePort4 = 0;
    public static final double soleTime = 1.0;

    public static int dirFacing = -1;

    //Vision acqusition ports
    public static final double centerXTarget = 310;
    public static final double targetSpread = 3;
    public static final double autoSpeed = .5;

}
