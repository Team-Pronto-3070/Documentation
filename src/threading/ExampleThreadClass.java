package threading;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

public class ExampleThreadClass extends Thread {
	// This is an example class for driving the robot that runs as a thread
	// Using Threads is not recommended as it has the potential to 
	// overload the Roborio or CRio and conflict with robot functionality
	
	private static final int LEFT_JOYSTICK_Y = 1;
	private static final int RIGHT_JOYSTICK_Y = 5;
	// Constants for the joystick axes settings

	boolean running = false;
	/*
	 * Since the boolean running controls when the contents of the thread
	 * are executed, we want running to default to false upon initialization.
	 */
	
	SpeedController motorLeft, motorRight;
	// Using SpeedController just means we can use any other class that
	// is a Speed Controller (like Jaguar, Talon, CANTalon, etc.)
	
	Joystick xbox;
	// standard joystick

	public ExampleThreadClass(SpeedController motor1, SpeedController motor2, Joystick x) {
		// Set class values to your input parameters
		motorLeft = motor1;
		motorRight = motor2;
		xbox = x;
	}

	public void setRun(boolean run) {
		running = run;
		/*
		 * This method will allow us to control the execution
		 * of the code in the while (running) loop.
		 */
	}
	
	// Override is a syntax thing, just copy it
	@Override
	public void run() {
		while (true) {
			while (running) {
				/*
				 * Consider this like a separate teleopPeriodic method. This
				 * will run parallel to all other teleopPeriodic methods or
				 * other threads. The code that you want to run as it relates to
				 * whatever you want this class to do goes in the while
				 * (running) loop.
				 * 
				 * The while (true) loop is to cause this method to emulate the
				 * teleopPeriodic method. The thread will always execute the
				 * while (true) loop as long as the robot is on, but the thread
				 * will only execute the while (running) loop when running is
				 * set to true; run your code when the boolean running is set to
				 * true.
				 */

				motorLeft.set(-xbox.getRawAxis(LEFT_JOYSTICK_Y));
				motorRight.set(xbox.getRawAxis(RIGHT_JOYSTICK_Y));
				// Example tank drive code with constants for the axes
				
				try {
					Thread.sleep(20);
					/*
					 * This causes the while (running) loop to pause for the parameter
					 * milliseconds. In this case, the while (running) loop
					 * would pause every 20 milliseconds.
					 * 
					 * Thread.sleep() should be placed in a try-catch statement
					 * like this. This prevents the code from crashing in case
					 * the thread gets interrupted.
					 */
				} catch (Exception ex) {
					// Don't worry about what this means, just copy it
					ex.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(500);
				/*
				 * Same thing as the above, except this pause applies to the
				 * while (true) loop. This pause causes the robot to check if
				 * the boolean running is true every 500 milliseconds, and if
				 * it is true, the while (running) loop will be executed
				 */
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			/*
			 * The pauses in the loops are necessary, as the loops would use
			 * tremendous processing power without them.
			 */
		}
	}

}
