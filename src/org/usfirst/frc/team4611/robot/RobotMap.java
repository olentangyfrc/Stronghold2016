package org.usfirst.frc.team4611.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int frontLeftWheel = 3; 
	public static final int backLeftWheel =2;
	public static final int frontRightWheel = 1; 
	public static final int backRightWheel =0;
	
	
	// Joystick  ports 
	public static final int leftJS = 1;
	public static final int rightJS = 2;
	
	// button board
	public static final int BB = 3;
	
	
	
	// L.A  values
	public static final int ACTUATOR_PORT = 6;
	public static final int TOP_LIMIT_PORT = 0;
	public static final int BOTTOM_LIMIT_PORT = 1;
	public static final int WINCH_LIMIT_PORT_TOP = 2;
	public static final int WINCH_LIMIT_PORT_BOTTOM = 3;
	public static final int ClawLimitPort = 4;
	
	public static final int LAcSpeed = 1; 
	
	public static final int solePort1 = 0;
	public static final int solePort2 = 1;	
	

	public static final int ascendant = 4;
	public static final int winchMotor = 1;
	
	public static final double forwardWinchSpeed = .75;
	public static final double backwardWinchSpeed = -.45;
	
	public static boolean DirFaced = false;
	
	public static double filterGrain = .5;
}
