/************************ PROJECT PHIL ************************/
/* Copyright (c) 2023 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartBoolean;
import com.stuypulse.stuylib.network.SmartNumber;

import edu.wpi.first.math.util.Units;

/*-
 * File containing tunable settings for every subsystem on the robot.
 *
 * We use StuyLib's SmartNumber / SmartBoolean in order to have tunable
 * values that we can edit on Shuffleboard.
 */
public interface Settings {
    public interface Drivetrain {
        double DIAMETER = Units.inchesToMeters(4);
        double CIRCUMFERENCE = Math.PI * DIAMETER;
        double TRACK_WIDTH = Units.inchesToMeters(26.9);
        double GEARING = 4.5;

        public interface Feedforward {
            double kV = 1.6658;
            double kA = 0.4515;

            double kVAngular = 6.34;
            double kAAngular = 1.35;
        }
    }

    public interface Elevator {
        double BOTTOM = Units.feetToMeters(1);
        double TOP = Units.feetToMeters(9);

        double OUTPUT_DIAMETER = Units.inchesToMeters(1.64);

        double GEARING = 9.0;

        double MASS = Units.lbsToKilograms(28.232);
    }
}
