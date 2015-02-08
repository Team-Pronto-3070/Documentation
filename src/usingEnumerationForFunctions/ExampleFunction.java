package usingEnumerationForFunctions;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

public class ExampleFunction {
	/*
	 * Even though this is sort of an enum, you create it as a class
	 * 
	 * This is a State Machine. It keeps track of what state the robot is as it
	 * performs a function. The purpose of this is to simplify implementing
	 * functions for robot.
	 */

	interface SpinningState {
		public SpinningState check();
		/*
		 * Consider this a syntax thing and just copy it For making a different
		 * State Machine, you would replace the SpinningState with whatever
		 * function you want to track the states of.
		 * 
		 * Ex: For a function that operates an elevator,
		 * 
		 * interface ElevatorState { public ElevatorState check(); }
		 */
	}

	static Joystick xbox;
	static SpeedController motor;
	SpinningState state;

	/*
	 * Standard creation of objects in your class. The term static is syntax.
	 * Just copy it. If a non-static object is created that needs to be static,
	 * Eclipse will give an error. That's how you know what needs to be static.
	 * 
	 * state is what will keep track of the current state you're in within the
	 * function.
	 */

	public ExampleFunction(SpeedController m, Joystick x) {
		// here's the Constructor
		motor = m;
		xbox = x;
		// Assigning your class objects to the parameter objects
		state = SpinningStates.Stopped;
		/*
		 * This is what determines what the default state is upon creating your
		 * State Machine in the main class.
		 */
	}

	enum SpinningStates implements SpinningState {
		// Stopped is a state
		Stopped {
			// @Override more syntax. Copy
			@Override
			public SpinningState check() {
				/*
				 * The check method will always be running if you're running the
				 * State Machine. However, the contents of check will vary based
				 * on the state that you're in.
				 */
				if (xbox.getRawButton(1)) {
					return StartSpinning;
					/*
					 * Pressing the A Button will transition to the
					 * StartSpinning state. The code will no longer run the
					 * check method of the Stopped state and will run the check
					 * method of the StartSpinning state.
					 */
				}

				return Stopped;
				/*
				 * The check method has to return a SpinningState, so until the
				 * A Button is pressed we want to stay in the Stopped state.
				 */
			}
		},

		StartSpinning {
			@Override
			public SpinningState check() {
				spin();
				/*
				 * The spin method gets called, which sets the motors, then
				 * transitions to the next state: Spinning.
				 */
				return Spinning;
			}
		},

		Spinning {
			@Override
			public SpinningState check() {
				if (!xbox.getRawButton(1)) {
					return StopSpinning;
					/*
					 * Until the A Button is released, the motor will remain set
					 * and the function will remain in the Spinning state.
					 */
				}

				return Spinning;
			}
		},

		StopSpinning {
			@Override
			public SpinningState check() {
				stop();
				/*
				 * Call the method that stops the motor, then transitions to the
				 * next state.
				 */
				return Stopped;
			}
		}
	}

	public void periodic() {
		state = state.check();
		/*
		 * The periodic method will be called on your State Machine in
		 * teleopPeriodic. This is what determines what your function is doing
		 * depending on what state it's in.
		 */
	}

	public void stopPeriodic() {
		stop();
		/*
		 * Set the motor to 0 if the robot is disabled for obvious reasons.
		 */
	}

	private static void spin() {
		motor.set(.5);
		/*
		 * Methods that perform the actual actions for your Robot. These get
		 * called depending on the state the State Machine is currently in.
		 */
	}

	private static void stop() {
		motor.set(0);
	}
}
