package org.cen.ui.web;

import org.cen.robot.IRobotService;
import org.cen.robot.IRobotServiceProvider;
import org.cen.robot.device.IRobotDevicesHandler;
import org.cen.robot.device.RobotDeviceListener;
import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.battery.BatteryDevice;
import org.cen.robot.device.battery.BatteryReadResult;

public class BeaconView implements IRobotService {

	private IRobotServiceProvider servicesProvider;

	@Override
	public void setServicesProvider(IRobotServiceProvider provider) {
		servicesProvider = provider;
		
	}
	
}

