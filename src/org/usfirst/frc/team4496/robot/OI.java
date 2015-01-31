package org.usfirst.frc.team4496.robot;

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
	public static Joystick controller = new Joystick(0);
	public static Button buttonA = new JoystickButton(controller, 1),
			buttonB = new JoystickButton(controller, 2),
			buttonX = new JoystickButton(controller, 3),
			buttonY= new JoystickButton(controller, 4),
			buttonLeftBumper = new JoystickButton(controller, 5),
			buttonRightBumper = new JoystickButton(controller, 6),
			buttonSelect = new JoystickButton(controller, 7),
			buttonStart = new JoystickButton(controller, 8),
			buttonLeftTrigger = new JoystickButton(controller, 9),
			buttonRightTrigger = new JoystickButton(controller, 10);
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
}

