package org.cen.simulRobot.device.timer;

import org.cen.robot.device.RobotDeviceRequest;
import org.cen.robot.device.timer.TimerResult;

public class RobotInitializingSimulResult extends TimerResult {

	public RobotInitializingSimulResult(RobotDeviceRequest request) {
		super(request);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[...]";
	}
}
