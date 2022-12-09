package com.stuypulse.robot.subsystems.drivetrain;

import com.revrobotics.CANSparkMax;
import com.stuypulse.robot.subsystems.IDrivetrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// Drivetrain.java
public class Drivetrain extends IDrivetrain {
	CANSparkMax[] left, right;

	DifferentialDrive drivetrain;

	public Drivetrain() {
		drivetrain = new DifferentialDrive(
			new MotorControllerGroup(left),
			new MotorControllerGroup(right)
		);
	}

	@Override
	public void tankDrive(double left, double right) {
		drivetrain.tankDrive(left, right);
	}
}
