/************************ PROJECT PHIL ************************/
/* Copyright (c) 2023 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

/** This file contains the different ports of motors, solenoids and sensors */
public interface Ports {
    public interface Gamepad {
        int DRIVER = 0;
        int OPERATOR = 1;
        int DEBUGGER = 2;
    }

    public interface Drivetrain {
        int LEFT_TOP = 10;
        int LEFT_MIDDLE = 11;
        int LEFT_BOTTOM = 12;

        int RIGHT_TOP = 13;
        int RIGHT_MIDDLE = 14;
        int RIGHT_BOTTOM = 15;
    }
}
