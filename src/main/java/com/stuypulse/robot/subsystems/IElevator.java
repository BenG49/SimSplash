package com.stuypulse.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class IElevator extends SubsystemBase {

	public abstract void setTargetHeight(double height);

	public abstract double getHeight();

	public abstract double getTargetHeight();

	public void addHeight(double delta) {
		setTargetHeight(getTargetHeight() + delta * 0.02);
	}

}
