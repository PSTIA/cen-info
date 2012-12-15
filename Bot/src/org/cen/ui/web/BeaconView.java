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
	
	private int testInt;

	public BeaconView(){
		super();
		settestInt(17);
	}
	@Override
	public void setServicesProvider(IRobotServiceProvider provider) {
		servicesProvider = provider;
		
	}
	public void settestInt(int test){
		testInt=test;
	}
	public int gettestInt(){
		return testInt;
	}
	
}

