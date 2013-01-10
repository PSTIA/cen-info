package org.cen.ui.web;

import org.cen.robot.IRobotService;
import org.cen.robot.IRobotServiceProvider;
import org.cen.robot.device.IRobotDevicesHandler;
import org.cen.robot.device.RobotDeviceListener;
import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.battery.BatteryDevice;
import org.cen.robot.device.battery.BatteryReadResult;
import org.cen.robot.device.navigation.PositionData;

public class BeaconView implements IRobotService {

	private IRobotServiceProvider servicesProvider;
	
	private int testInt;
	private double computedXRobotPosition;
	private double computedYRobotPosition;

	public BeaconView(){
		super();
		settestInt(17);
		setComputedXRobotPosition(0);
		setComputedYRobotPosition(0);
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
	public double getComputedXRobotPosition() {
		return computedXRobotPosition;
	}
	public void setComputedXRobotPosition(double computedXRobotPosition) {
		this.computedXRobotPosition = computedXRobotPosition;
	}
	public double getComputedYRobotPosition() {
		return computedYRobotPosition;
	}
	public void setComputedYRobotPosition(double computedYRobotPosition) {
		this.computedYRobotPosition = computedYRobotPosition;
	}
	
}

