package com.stuypulse.robot.slides;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static com.stuypulse.robot.constants.Ports.Drivetrain.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain09 extends SubsystemBase {
    
    private CANSparkMax[] left, right;

    private DifferentialDrive drivetrain;

    public Drivetrain09() {
        left = new CANSparkMax[] {
            new CANSparkMax(LEFT_TOP, MotorType.kBrushless),
            new CANSparkMax(LEFT_MIDDLE, MotorType.kBrushless),
            new CANSparkMax(LEFT_BOTTOM, MotorType.kBrushless)
        };

        right = new CANSparkMax[] {
            new CANSparkMax(RIGHT_TOP, MotorType.kBrushless),
            new CANSparkMax(RIGHT_MIDDLE, MotorType.kBrushless),
            new CANSparkMax(RIGHT_BOTTOM, MotorType.kBrushless)
        };

        drivetrain = new DifferentialDrive(
            new MotorControllerGroup(left),
            new MotorControllerGroup(right)
        );
    }

    public void tankDrive(double left, double right) {
        drivetrain.tankDrive(left, right);
    }

}
