package usingEnumerationForFunctions;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

public class ExampleFunction {
	
	interface SpinningState {
		public SpinningState check();
	}
	
	static Joystick xbox;
	static SpeedController motor;
	SpinningState state;
	
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
