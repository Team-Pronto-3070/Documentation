
package usingEnumerationForFunctions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {
	
	CANTalon motor;
	Joystick xbox;
	// Standard object creation
	
	ExampleFunction spinner;
	/*
	 * The explicit name of your class
	 * followed by the label you will use
	 * to refer to it in your main class, which
	 * is this one.
	 */
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	motor = new CANTalon(1);
    	xbox = new Joystick(1);
    	
    	spinner = new ExampleFunction(motor, xbox);
    	/*
    	 * You give your State Machine the parameters
    	 * that were set up in the Constructor.
    	 */
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        spinner.periodic();
        /*
         * This is what operates the check method
         * of the current state that spinner is in.
         */
    }
    
    public void disabledInit() {
    	spinner.stopPeriodic();
    	// Stops the motor.
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
