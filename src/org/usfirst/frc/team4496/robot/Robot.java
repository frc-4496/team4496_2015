package org.usfirst.frc.team4496.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4496.robot.commands.ExampleCommand;
import org.usfirst.frc.team4496.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
	//start of added code
	RobotDrive myDrive;
	Talon liftDrive;
	Compressor compressor;
	Solenoid grabArm;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        
        myDrive = new RobotDrive(RobotMap.leftFrontMotor, RobotMap.leftRearMotor, RobotMap.rightFrontMotor, RobotMap.rightFrontMotor);
        liftDrive = new Talon(RobotMap.mainLiftMotor);
        //compressor = new Compressor(RobotMap.compressor);
        //grabArm = new Solenoid(RobotMap.solenoid);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        //main drive setup
        myDrive.mecanumDrive_Cartesian(OI.controller.getY(), OI.controller.getX(), OI.controller.getTwist(), 0);
        
        
        /*
        //main lift system stuff
        if(OI.buttonLeftBumper.get()){
        	liftDrive.set(1);
        } else if(OI.buttonRightBumper.get()){
        	liftDrive.set(-1);
        } else {
        	liftDrive.set(0);
        }
        
        //main grab setup
        if(OI.controller.getZ() > 0.5){
        	grabArm.set(true);
        } else if(OI.controller.getZ() < 0.5){
        	grabArm.set(false);
        }
        */
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
