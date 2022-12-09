package com.stuypulse.robot.subsystems.drivetrain;

import static com.stuypulse.robot.constants.Settings.Drivetrain.*;

import com.stuypulse.robot.subsystems.IDrivetrain;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.RoboRioSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SimDrivetrain extends IDrivetrain {

	private DifferentialDrivetrainSim sim;

	private Field2d field;

	public SimDrivetrain() {
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

		field = new Field2d();
		SmartDashboard.putData(field);
	}

	@Override
	public void tankDrive(double left, double right) {
		sim.setInputs(
			RoboRioSim.getVInVoltage() * left,
			RoboRioSim.getVInVoltage() * right
		);
	}

	@Override
	public void periodic() {
		field.setRobotPose(sim.getPose());
	}

	@Override
	public void simulationPeriodic() {
		sim.update(0.02);
	}

}
