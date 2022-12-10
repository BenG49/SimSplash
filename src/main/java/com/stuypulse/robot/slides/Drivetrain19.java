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
        sim = new DifferentialDrivetrainSim(
			// identifies a drivetrain state space model from SysId gains
			LinearSystemId.identifyDrivetrainSystem(
				Feedforward.kV,                        // linear velocity gain
				Feedforward.kA,                        // linear acceleration gain
				Feedforward.kVAngular,                 // angular velocity gain
				Feedforward.kAAngular,                 // angular acceleration gain
				TRACK_WIDTH                            // track width of the drivetrain
			),
			DCMotor.getNEO(6), // 6 NEO motors
			4.5,                 // 4.5:1 gearing reduction
			TRACK_WIDTH,                 // track width of the drivetrain
			DIAMETER / 2,                // radius of the wheels

			// give the drivetrain measurement noise (none in this example)
			VecBuilder.fill(0, 0, 0, 0, 0, 0, 0)
		);
    }

    public void tankDrive(double left, double right) {}

}
