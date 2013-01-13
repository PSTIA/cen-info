package org.cen.ui.web;

import org.cen.robot.IRobotService;
import org.cen.robot.IRobotServiceProvider;
import org.cen.robot.device.IRobotDevicesHandler;
import org.cen.robot.device.RobotDeviceListener;
import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.beacon.BeaconDevice;
import org.cen.robot.device.beacon.BeaconReadResult;
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
		IRobotDevicesHandler handler = servicesProvider.getService(IRobotDevicesHandler.class);
		handler.addDeviceListener(new RobotDeviceListener() {
			@Override
			public String getDeviceName() {
				return BeaconDevice.NAME;
			}

			@Override
			public void handleResult(RobotDeviceResult result) {
				if (result instanceof BeaconReadResult) {
					computedXRobotPosition = ((BeaconReadResult) result).getComputedXRobotPosition();
					computedYRobotPosition = ((BeaconReadResult) result).getComputedYRobotPosition();
				}
			}
		});
		
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

