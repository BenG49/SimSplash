/************************ PROJECT PHIL ************************/
/* Copyright (c) 2023 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot;

import com.stuypulse.robot.commands.DriveCommand;
import com.stuypulse.robot.commands.ElevatorDrive;
import com.stuypulse.robot.commands.auton.DoNothingAuton;
import com.stuypulse.robot.subsystems.IDrivetrain;
import com.stuypulse.robot.subsystems.IElevator;
import com.stuypulse.robot.subsystems.drivetrain.SimDrivetrain;
import com.stuypulse.robot.subsystems.elevator.SimElevator;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.AutoGamepad;
import com.stuypulse.stuylib.input.gamepads.keyboard.SimKeyGamepad;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    // Gamepads
    public final Gamepad driver = new SimKeyGamepad();
    // public final Gamepad operator = new AutoGamepad(Ports.Gamepad.OPERATOR);
    
    // Subsystem
    public final IDrivetrain drivetrain = new SimDrivetrain();
    private final IElevator elevator = new SimElevator();

    // Autons
    private static SendableChooser<Command> autonChooser = new SendableChooser<>();

    // Robot container

    public RobotContainer() {
        configureDefaultCommands();
        configureButtonBindings();
        configureAutons();
    }

    /****************/
    /*** DEFAULTS ***/
    /****************/

    private void configureDefaultCommands() {}

    /***************/
    /*** BUTTONS ***/
    /***************/

    private void configureButtonBindings() {
        drivetrain.setDefaultCommand(new DriveCommand(drivetrain, driver));
        elevator.setDefaultCommand(new ElevatorDrive(elevator, driver));
    }

    /**************/
    /*** AUTONS ***/
    /**************/

    public void configureAutons() {
        autonChooser.setDefaultOption("Do Nothing", new DoNothingAuton());

        SmartDashboard.putData("Autonomous", autonChooser);
    }

    public Command getAutonomousCommand() {
        return autonChooser.getSelected();
    }
}
