package com.stuypulse.robot.slides;
import static com.stuypulse.robot.constants.Settings.Drivetrain.*;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain19 extends SubsystemBase {
    
    // private CANSparkMax[] left, right;

    // private DifferentialDrive drivetrain;

    private DifferentialDrivetrainSim sim;

    public Drivetrain19() {
		// TODO: add comments for each line of constructor
        sim = new DifferentialDrivetrainSim(
			LinearSystemId.identifyDrivetrainSystem(
				Feedforward.kV,
				Feedforward.kA,
				Feedforward.kVAngular,
				Feedforward.kAAngular,
				TRACK_WIDTH
			),
			DCMotor.getNEO(6),
			4.5,
			TRACK_WIDTH,
			DIAMETER / 2,
			VecBuilder.fill(0, 0, 0, 0, 0, 0, 0)
		);
    }

    public void tankDrive(double left, double right) {}

}
