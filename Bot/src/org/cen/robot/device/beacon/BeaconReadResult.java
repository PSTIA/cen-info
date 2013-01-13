package org.cen.robot.device.beacon;

import org.cen.robot.device.RobotDeviceRequest;
import org.cen.robot.device.RobotDeviceResult;

public class BeaconReadResult extends RobotDeviceResult {
	private double computedXRobotPosition;
	private double computedYRobotPosition;
	
	public BeaconReadResult(RobotDeviceRequest request) {
		super(request);
	}

	public double getComputedXRobotPosition() {
		return computedXRobotPosition;
	}

	public double getComputedYRobotPosition() {
		return computedYRobotPosition;
	}

}
