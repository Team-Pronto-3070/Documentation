
package threading.example;

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
	
	ExampleThreadClass drive;
	// the Thread class we made
	
	CANTalon leftMotor, rightMotor;
	Joystick xbox;
	// Standard motor and joystick creation
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	leftMotor = new CANTalon(1);
    	rightMotor = new CANTalon(2);
    	// standard assigning motor IDs
    	
    	xbox = new Joystick(1);
    	// standard
    	
    	drive = new ExampleThreadClass(leftMotor, rightMotor, xbox);
    	// assigning the thread class the parameters we set up
    	
    	drive.start();
    	/*
    	 * This starts the thread.
    	 * The thread will always be on because of the while (true) loop, 
    	 * but the contents of the while (running) loop will only execute when
    	 * the boolean running is set to true.
    	 * The boolean running is default set to false. 
    	 */
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }
    
    public void teleopInit() {
    	drive.setRun(true);
    	/*
    	 * This sets the boolean running in the class to true upon
    	 * enabling teleop, meaning that the thread contents will
    	 * begin executing.
    	 */
    }
    
    public void disabledInit() {
    	if (drive != null) {
    		// Don't worry about drive != null, just copy it
    		
    		drive.setRun(false);
    		/*
    		 * This will set the boolean running to false upon
    		 * disabling teleop, stopping the execution of the
    		 * while (running) loop in the thread. The 
    		 * while (true) loop will always be running until
    		 * the robot is turned off, but the actual operations
    		 * of the code in the while (running) will be suspended
    		 * because it exits that loop.
    		 */
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
