package examplePIDMecanumDrive;

import edu.wpi.first.wpilibj.CANTalon;

public class PIDMecDrive {

	CANTalon motorFrontLeft, motorFrontRight, motorRearLeft, motorRearRight;

	double x, y, z;

	public PIDMecDrive(CANTalon mFL, CANTalon mFR, CANTalon mRL, CANTalon mRR) {
		motorFrontLeft = mFL;
		motorFrontRight = mFR;
		motorRearLeft = mRL;
		motorRearRight = mRR;

		setMotorControlModes();

		setMotorSensorControl();

		setMotorPIDValues();
	}

	private void setMotorControlModes() {
		motorFrontLeft.changeControlMode(CANTalon.ControlMode.Speed);
		motorFrontRight.changeControlMode(CANTalon.ControlMode.Speed);
		motorRearLeft.changeControlMode(CANTalon.ControlMode.Speed);
		motorRearRight.changeControlMode(CANTalon.ControlMode.Speed);
	}
	
	private void setMotorSensorControl() {
		motorFrontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		motorFrontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		motorRearLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		motorRearRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	}

	private void setMotorPIDValues() {
		
	}

	public void drive(double x, double y, double rotation) {

	}

}
