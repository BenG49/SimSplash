package com.stuypulse.robot.commands;

import com.stuypulse.robot.constants.Settings;
import com.stuypulse.robot.subsystems.IElevator;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorDrive extends CommandBase {

	private IElevator elevator;
	private Gamepad gamepad;

	public ElevatorDrive(IElevator elevator, Gamepad gamepad) {
		this.elevator = elevator;
		this.gamepad = gamepad;

		addRequirements(elevator);
	}

	public void execute() {
		elevator.addHeight(Settings.Elevator.MOVE_SPEED * gamepad.getRightY());
	}

}
