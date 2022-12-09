package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.IDrivetrain;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

// DriveCommand.java
public class DriveCommand extends CommandBase {

	private IDrivetrain drivetrain;
	private Gamepad gamepad;

	public DriveCommand(IDrivetrain drivetrain, Gamepad gamepad) {
		this.drivetrain = drivetrain;
		this.gamepad = gamepad;
	}

	public void execute() {
		drivetrain.tankDrive(gamepad.getLeftTrigger(), gamepad.getRightTrigger());
	}

}
