package org.usfirst.frc.team4496.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;







//import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	
	//start of added code
	RobotDrive mainDrive;
	Talon liftDrive;
	//Compressor compressor;
	//Solenoid grabArm;
    Command testCommand;

    /**
     * This function is run when the robot is first started up and should be\
     *
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        
        //mainDrive = new RobotDrive(RobotMap.leftFrontMotor, RobotMap.leftRearMotor, RobotMap.rightFrontMotor, RobotMap.rightFrontMotor);
        mainDrive = new RobotDrive(0, 1, 2, 3);
        mainDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        mainDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        liftDrive = new Talon(RobotMap.mainLiftMotor);
        //compressor = new Compressor(RobotMap.compressor);
        //grabArm = new Solenoid(RobotMap.solenoid);
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
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
	@SuppressWarnings("deprecation")
	public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        //main drive setup
        
        //set the input values
        double lXVal = OI.controller.getRawAxis(0);
        double lYVal = OI.controller.getRawAxis(1);
        double rXVal = OI.controller.getRawAxis(4);
        
        //round the values
        lXVal = ((double)((int)(lXVal  * 10)) ) / 10;
        lYVal = ((double)((int)(lYVal  * 10)) ) / 10;
        rXVal = ((double)((int)(rXVal  * 10)) ) / 10;
        
        //output the values
        SmartDashboard.putDouble("LeftStickXValue", lXVal);
        SmartDashboard.putDouble("LeftStickYValue", lYVal);
        SmartDashboard.putDouble("RightStickXValue", rXVal);
        SmartDashboard.putInt("POVPad", OI.controller.getPOV());
        
        //drive with the values
        mainDrive.mecanumDrive_Cartesian(lXVal, lYVal, rXVal, 0);
        
   
        //main lift system stuff
        if(OI.controller.getPOV() == 0){
        	liftDrive.set(1);
        } else if(OI.controller.getPOV() == 180){
        	liftDrive.set(-1);
        } else {
        	liftDrive.set(0);
        }
        
        /*
        //main grab setup
        if(OI.controller.getRawAxis(2) > .1{
        	grabArm.set(true);
        } else if(OI.controller.getRawAxis(3) < .1){
        	grabArm.set(false);
        }
        */
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic(){
    	testCommand.start();
    }
}
