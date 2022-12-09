package com.stuypulse.robot.subsystems.elevator;

import static com.stuypulse.robot.constants.Settings.Elevator.*;

import com.stuypulse.robot.subsystems.IElevator;
import com.stuypulse.stuylib.control.Controller;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SimElevator extends IElevator {

	private ElevatorSim sim;

	private Controller control;

	private double targetHeight;

	private Mechanism2d mech;
	private MechanismLigament2d elevatorLigament;

	public SimElevator() {
		sim = new ElevatorSim(
			DCMotor.getNEO(4),
			GEARING,
			MASS,
			OUTPUT_DIAMETER / 2.0,
			BOTTOM,
			TOP,
			true
		);

		mech = new Mechanism2d(2, 6);
		MechanismRoot2d root = mech.getRoot("ElevatorRoot", 1, 0);
		elevatorLigament = root.append(
			new MechanismLigament2d("Elevator", 1, 90.0));

		SmartDashboard.putData("Mech2d", mech);
	}

	@Override
	public void setTargetHeight(double height) {
		height = MathUtil.clamp(height, BOTTOM, TOP);
	}

	@Override
	public void periodic() {
		// make the maximum height 5 + 0.5 and minimum height 0.5
		elevatorLigament.setLength(
			sim.getPositionMeters() * (5 / TOP) + 0.5);
	}

	@Override
	public void simulationPeriodic() {
		sim.setInputVoltage(
			control.update(targetHeight, sim.getPositionMeters())
		);

		sim.update(0.02);
	}

}
