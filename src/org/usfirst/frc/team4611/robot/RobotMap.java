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
    public static final double feedingWheelShooterSpeed = -0.4;
    public static final double launchingWheelShooterSpeed = .40;

    //Solenoid ports
    public static final int solePort1 = 3;
    public static final int solePort2 = 2;
    public static final int solePort3 = 1;
    public static final int solePort4 = 0;
    public static final double soleTime = 1.0;

    public static int dirFacing = -1;

    //Vision acqusition ports and speeds
    public static double centerXTarget = 325; //added 30, used to be 427
    //public static final double centerYLimit = 320;
    public static final double targetSpread = 5;
    public static final double visionAutoSpeed = .55;
    public static final double rearWheelRatio = 1;
    public static final double minTurnSpeed = 0.75;
    public static final double maxTurnSpeed = 1;

    //autuonomous speeds
    public static final double autoTurnSpeed = 1;
    public static final double autoDriveSpeed = 0.6;
    public static final double rockWallSpeed = 1, moatSpeed = 1,
            rampartSpeed = 1, roughTerrainSpeed = 1;
    public static final double rockWallTime = 2.5, moatTime = 2.5, rampartTime = 2.5,
            roughTerrainTime = 2.5;
    public static final double aimTime = 2;

    //FREAKING DELAYS
    public static final double VA_DELAY_1 = 0.5, SHOOTING_DELAY_2 = 2;

    //swivel arm variables
    public static final int swivelMotorPort = 6;
    public static final double maxSwivelSpeed = 0.5;

    public static final int topLimit = 0;
    public static final int bottomLimit = 1;
    public static final int spikePort = 2;
}
