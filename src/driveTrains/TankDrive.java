
package driveTrains;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
/*
 * The imports are added here so that the Compiler knows
 * what information it needs to access to be able to
 * compile the code and run it on the robot.
 * 
 * Imports only need to be added once in the class.
 */

public class TankDrive extends IterativeRobot {
	
	CANTalon leftMotor, rightMotor;
	Joystick xbox;
	/*
	 * The objects we use are created here, inside the
	 * brackets for public class Main extends IterativeRobot
	 * but outside the brackets for any of the other methods.
	 * 
	 * The leftmost term is what denotes the object we are
	 * creating, and the term(s) following it is the name
	 * we will use to reference that individual instance of the
	 * object in the future.
	 * 
	 * In this case, we are making instances of the CANTalon and
	 * Joystick classes. Those instances are given the labels of
	 * leftMotor, rightMotor, and xbox.
	 */
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	/*
    	 * robotInit() is where we assign what physical object on
    	 * the robot corresponds to our instances of those objects
    	 * in code.
    	 */
    	
    	leftMotor = new CANTalon(1);
    	/*
    	 * To set what each instance corresponds to, we set the
    	 * instance to equal the object plugged into the specified
    	 * port on the robot. The port is specified by the number
    	 * that we put in the parentheses.
    	 */
    	rightMotor = new CANTalon(2);
    	
    	xbox = new Joystick(1);
    	
    	/*
    	 * The general syntax for initializing instances of objects
    	 * is the equals sign, followed by the word new, followed by
    	 * what the object is, with parentheses attached. The parameters
    	 * in the parentheses will usually be the port of the physical
    	 * object on the robot.
    	 *
    	 * If the code fails to upload and the console prints the
    	 * NullPointerException error, it means you are trying to use
    	 * one of your instances of an object without assigning it to
    	 * a physical port in the robotInit().
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
    	/*
    	 * Tank Drive means just that; we will drive the robot like
    	 * a tank. One joystick will operate the motors of one side
    	 * of the robot, and the other joystick will operate the
    	 * motors on the other side.
    	 */
    	
    	leftMotor.set(-xbox.getRawAxis(1));
    	/*
    	 * To set the speed of a motor, we call the name of the
    	 * instance of the object and use the .set method on it.
    	 * The parameter for the .set method is a double value
    	 * between -1.0 for full reverse and 1.0 for full forward,
    	 * with 0.0 being stopped.
    	 * 
    	 * To set the speed of the motor to equate to joystick input,
    	 * we use the .getRawAxis() method on our joystick instance
    	 * and place that as the parameter for the .set method on
    	 * the motor.
    	 * 
    	 * Calling the .getRawAxis() on the joystick looks at the
    	 * position of the specified joystick at the moment the method is
    	 * called and returns the joystick position as a double value
    	 * between -1.0 and 1.0.
    	 * 
    	 * xbox.getRawAxis(1) is the equivalent of a value x where x
    	 * depends on the position of the joystick. The parameter for
    	 * .getRawAxis() is the value of the joystick axis that we want
    	 * to reference. 1 refers to the Y-Axis on the left joystick of
    	 * the xbox controller. Check the ReadMe.txt for the integer
    	 * values equating to joystick axes and buttons.
    	 * 
    	 * As a side note, the left motors will usually need to be set to
    	 * a negative value as the robot is built with the left motors
    	 * inverted relative to the right ones. One motor's forward is
    	 * the other motor's backwards, hence why one side is inverted
    	 * with the negative.
    	 */
    	rightMotor.set(xbox.getRawAxis(5));
    	
    	/*
    	 * Something to note is that there is a class, RobotDrive, that
    	 * will handle many kinds of drive-trains for the robot. It is
    	 * recommended to use the RobotDrive class over manual if you
    	 * can help it, as the RobotDrive simplifies the drive code
    	 * immensely.
    	 */
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
