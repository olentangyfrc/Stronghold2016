
package org.usfirst.frc.team4611.robot;

import java.util.prefs.Preferences;

import org.usfirst.frc.team4611.robot.commands.Lane2;
import org.usfirst.frc.team4611.robot.commands.Lane3;
import org.usfirst.frc.team4611.robot.commands.Lane4;
import org.usfirst.frc.team4611.robot.commands.Lane5;
import org.usfirst.frc.team4611.robot.commands.LowBar;
import org.usfirst.frc.team4611.robot.commands.TestAuto;
import org.usfirst.frc.team4611.robot.subsystems.FeedSolenoid;
import org.usfirst.frc.team4611.robot.subsystems.FlipSolenoid;
import org.usfirst.frc.team4611.robot.subsystems.ShooterWheels;
import org.usfirst.frc.team4611.robot.subsystems.SwivelArm;
//import org.usfirst.frc.team4611.robot.subsystems.VisionTank;
import org.usfirst.frc.team4611.robot.subsystems.leftSide;
import org.usfirst.frc.team4611.robot.subsystems.rightSide;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    //public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static OI oi;
    public static leftSide leftS = new leftSide();
    public static rightSide rightS = new rightSide();

    //public static pneumaticSubsystem shooter = new pneumaticSubsystem();
    public static FlipSolenoid flipSolenoid = new FlipSolenoid();
    public static FeedSolenoid feedSolenoid = new FeedSolenoid();
    public static ShooterWheels shooterWheels = new ShooterWheels();
    public static SwivelArm swivelArm = new SwivelArm();

    public static Preferences prefs;
    Command autonomousCommand;
    SendableChooser chooser;

    public static NetworkTable table;

    //CameraServer server;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */

    @Override
    public void robotInit() {
        //Initializes camera feed on driver station
        //CameraServer server = CameraServer.getInstance();
        //server.setQuality(50);
        //server.startAutomaticCapture("cam0");

        oi = new OI();

        this.chooser = new SendableChooser();
        this.chooser.addDefault("Default Program",
                new TestAuto());
        this.chooser.addObject("Lane 1: Low Bar", new LowBar());

        this.chooser.addObject("Lane 2: Drive", new Lane2(Defense.DRIVE));
        this.chooser.addObject("Lane 2: Cheval de Frise",
                new Lane2(Defense.CHEVALDEFRISE));
        this.chooser.addObject("Lane 2: Portcullis",
                new Lane2(Defense.PORTCULLIS));

        this.chooser.addObject("Lane 3: Drive", new Lane3(Defense.DRIVE));
        this.chooser.addObject("Lane 3: Cheval de Frise",
                new Lane3(Defense.CHEVALDEFRISE));
        this.chooser.addObject("Lane 3: Portcullis",
                new Lane3(Defense.PORTCULLIS));

        this.chooser.addObject("Lane 4: Drive", new Lane4(Defense.DRIVE));
        this.chooser.addObject("Lane 4: Cheval de Frise",
                new Lane4(Defense.CHEVALDEFRISE));
        this.chooser.addObject("Lane 4: Portcullis",
                new Lane4(Defense.PORTCULLIS));

        this.chooser.addObject("Lane 5: Drive", new Lane5(Defense.DRIVE));
        this.chooser.addObject("Lane 5: Cheval de Frise",
                new Lane5(Defense.CHEVALDEFRISE));
        this.chooser.addObject("Lane 5: Portcullis",
                new Lane5(Defense.PORTCULLIS));

        SmartDashboard.putData("Auto Chooser", this.chooser);

        //this.autonomousCommand = new autonomousCommandGroup();
        //table = NetworkTable.getTable("GRIP/data");
    }

    public enum Defense {
        CHEVALDEFRISE, PORTCULLIS, DRIVE;
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
        // schedule the autonomous command (example)

        this.autonomousCommand = (Command) this.chooser.getSelected();
        if (this.autonomousCommand != null) {
            this.autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (this.autonomousCommand != null) {
            this.autonomousCommand.cancel();
        }

    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //LiveWindow.run();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
