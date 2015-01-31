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

Encoder (3, 4) Right wheels (values negative)
Encoder (1, 2) Left wheels

1ft = Left Encoder (1) ~ -227
      Right Encoder (3) ~ 369.25
      
1 ft = ultrasonic = 0.112304
      
Driving set distance using encoders:
      Left: (-227 * FEET) + 80
      Right: (369 * FEET) - 80
      80 makes the distance more precise

Window motor - 6
Wheels - 7
forward on the wheels draws in
