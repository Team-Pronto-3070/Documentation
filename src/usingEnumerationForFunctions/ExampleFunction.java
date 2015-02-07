package usingEnumerationForFunctions;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

public class ExampleFunction {
	/*
	 * Even though this is sort of an enum, you create
	 * it as a class
	 * 
	 * This is a State Machine. It keeps track of what
	 * state the robot is as it performs a function.
	 * The purpose of this is to simplify implementing 
	 * functions for robot.
	 */
	
	interface SpinningState {
		public SpinningState check();
		/*
		 * Consider this a syntax thing and just copy it
		 * For making a different State Machine, you would
		 * replace the SpinningState with whatever function
		 * you want to track the states of.
		 * 
		 * Ex: For a function that operates an elevator,
		 * 
		 * interface ElevatorState {
		 * 	public ElevatorState check();
		 * }
		 */
	}
	
	static Joystick xbox;
	static SpeedController motor;
	SpinningState state;
	/*
	 * 
	 */
	
	public ExampleFunction(SpeedController m, Joystick x) {
		motor = m;
		xbox = x;
		state = SpinningStates.Stopped;
	}
	
	enum SpinningStates implements SpinningState {
		Stopped {
			@Override
			public SpinningState check() {
				if (xbox.getRawButton(1)) {
					return StartSpinning;
				}
				
				return Stopped;
			}
		},
		
		StartSpinning {
			@Override
			public SpinningState check() {
				spin();
				return Spinning;
			}
		},
		
		Spinning {
			@Override
			public SpinningState check() {
				if (!xbox.getRawButton(1)) {
					return StopSpinning;
				}
				
				return Spinning;
			}
		},
		
		StopSpinning {
			@Override
			public SpinningState check() {
				stop();
				return Stopped;
			}
		}
	}
	
	public void periodic() {
		state = state.check();
	}
	
	public void stopPeriodic() {
		stop();
		state = SpinningStates.Stopped;
	}
	
	private static void spin() {
		motor.set(.5);
	}

	private static void stop() {
		motor.set(0);
	}
}
