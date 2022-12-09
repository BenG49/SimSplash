package com.stuypulse.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class IDrivetrain extends SubsystemBase {

	public abstract void tankDrive(double left, double right);

}
