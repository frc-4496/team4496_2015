package org.usfirst.frc.team4496.robot.commands;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Runs a test that tests all values in each motor
 */
public class TestCommand extends Command {

    public TestCommand() {
        // Use requires() here to declare subsystem dependencies
    	super("TestCommand");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotDrive testDrive = new RobotDrive(0, 1, 2, 3);
    	System.out.print("The teleop is running");
        double x, y;
        for (x = -1; x > 1; x += .1){
        	for (y = -1; y > 1; x += .1){
        		testDrive.mecanumDrive_Cartesian(x, y, 0, 0);
        		System.out.print("The loop is running\n" + x + ":" + y);
        		Timer.delay(.01);
        	}
        	Timer.delay(.01);
        	y = -1;
        	if(x == 1)
        		end = true;
        }
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    public static boolean end = false;
}
