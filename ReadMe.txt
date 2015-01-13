GetRawAxis(0) Left Stick X-axis
GetRawAxis(1) Left Stick Y-axis
GetRawAxis(2) Left Trigger
GetRawAxis(3) Right Trigger
GetRawAxis(4) Right Stick X-axis
GetRawAxis(5) Right Stick Y-axis

GetRawButton(1) A Button
GetRawButton(2) B Button
GetRawButton(3) X Button
GetRawButton(4) Y Button
GetRawButton(5) Left Bumper
GetRawButton(6) Right Bumper
GetRawButton(7) Back Button
GetRawButton(8) Start Button
GetRawButton(9) Left Stick click
GetRawButton(10) Right Stick click

Note: Axes have to be negative

RobotDrive(0, 1)
Encoder (4, 5) Right wheels (values negative)
Encoder (2, 3) Left wheels

1ft = 1 -227
      2 369.25	

drive.setInvertedMotor(MotorType.kRearLeft, true);
drive.setInvertedMotor(MotorType.kRearRight, false);
-Put in robotInit to correct motors

drive.arcadeDrive(-xbox.getRawAxis(4) , -xbox.getRawAxis(5));
-Drive code