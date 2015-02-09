package driveTrains;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class ExampleRobotDrive extends IterativeRobot {

	CANTalon mFrontLeft, mFrontRight, mRearLeft, mRearRight;
	Joystick xbox;
	// Standard motor and joystick creation

	RobotDrive mechDrive, arcadeDrive, tankDrive;
	/*
	 * Creating the 3 different RobotDrive instances. mechDrive will be used to
	 * demonstrate mecanum wheel drive. arcadeDrive will be used to demonstrate
	 * arcade drive. tankDrive will be used to demonstrate tank drive.
	 */

	double a, b, c, d;
	// The values we will use for motor input

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		mFrontLeft = new CANTalon(1);
		mFrontRight = new CANTalon(2);
		mRearLeft = new CANTalon(3);
		mRearRight = new CANTalon(4);
		// Assign ports to motors

		xbox = new Joystick(1);
		// Assign joystick port

		mechDrive = new RobotDrive(mFrontLeft, mRearLeft, mFrontRight,
				mRearRight);
		mechDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		mechDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		/*
		 * For mecanum drive to work, it requires a motor to operate all four
		 * wheels on the robot, thus the constructor for our mechDrive instance
		 * needs all four motors in the parameters.
		 * 
		 * Additionally, the RobotDrive class has a built in method for setting
		 * motors to be inverted. The syntax is called above. Notably, the
		 * syntax for specifying which motors to invert works independent of
		 * what you named the motors. The syntax will always be
		 * RobotDrive.MotorType.kFrontLeft, where kFrontLeft can be replaced
		 * with the other three motor options (kFrontRight, kRearLeft,
		 * kRearRight).
		 */

		arcadeDrive = new RobotDrive(mFrontLeft, mFrontRight);
		arcadeDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		/*
		 * Arcade drive only requires motors for the left side and motors for
		 * the right.
		 */

		tankDrive = new RobotDrive(mFrontLeft, mFrontRight);
		tankDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		/*
		 * Tank drive only requires motors for the left and right.
		 */

		a = 0.0;
		b = 0.0;
		c = 0.0;
		d = 0.0;
		/*
		 * These are the variables we will input into the different drive
		 * methods. Upon initialization we will assign them to zero just to
		 * avoid any possible errors later in the code.
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
		a = xbox.getRawAxis(0);
		// a is assigned the value of the left joystick x-axis

		b = xbox.getRawAxis(1);
		// b is assigned the value of the left joystick y-axis

		c = xbox.getRawAxis(4);
		// c is assigned the value of the right joystick x-axis

		d = xbox.getRawAxis(5);
		// d is assigned the value of the right joystick y-axis

		mechDrive.mecanumDrive_Cartesian(a, b, c, 0);
		/*
		 * Mecanum wheels enable the robot drive like a car, but also allows the
		 * robot to move laterally, side-to-side.
		 * 
		 * To use the mecanum code that FIRST provide, simply call the
		 * mecanumDrive_Cartesian method on the robot drive instance that you
		 * wish to drive the mecanum wheels.
		 * 
		 * The parameters for the mecanum method are the speed the robot should
		 * drive in the x, speed robot should drive in the y, and rate of
		 * rotation which is independent of the translation, and the gyro angle.
		 * Don't worry about the gyro angle.
		 * 
		 * To achieve our desired movement, we use the left joystick x value for
		 * lateral movement, left joystick y value for forward/backward
		 * movement, and the right joystick x value for the rotation.
		 */

		arcadeDrive.arcadeDrive(b, c);
		/*
		 * Arcade drive drives the robot like a car. The robot can move forward,
		 * backward, and turn.
		 * 
		 * The arcadeDrive method is called on the desired instance of
		 * RobotDrive.
		 * 
		 * The parameters are the speed the robot drives in the y, and the rate
		 * the robot should turn.
		 * 
		 * In this example, we set the forward/backward movement to be
		 * controller by the left joystick y-axis, and the turning to be
		 * controlled by the right joystick x-axis.
		 */

		tankDrive.tankDrive(b, d);
		/*
		 * There is already documentation for how tank drive works, so I won't
		 * describe it here, and it's pretty self-explanatory anyway.
		 * 
		 * In this case, the left joystick y-axis controls the left motor, and
		 * the right joystick y-axis controls the right motor.
		 */

		/*
		 * This class is purely for example to show how to utilize the
		 * RobotDrive class. You would never want to call three different
		 * RobotDrive instances with three different ways of operating them.
		 * There is only one drive-train on the robot, so only one RobotDrive
		 * instance is necessary. You do not want to try to drive the robot
		 * multiple different ways simultaneously, for obvious reasons.
		 */

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
