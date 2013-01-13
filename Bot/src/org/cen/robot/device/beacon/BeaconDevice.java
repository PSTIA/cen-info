package org.cen.robot.device.beacon;

import org.cen.com.IComService;
import org.cen.com.out.OutData;
import org.cen.robot.IRobotServiceProvider;
import org.cen.robot.device.AbstractRobotDevice;
import org.cen.robot.device.RobotDeviceRequest;
import org.cen.robot.device.beacon.com.BeaconInDataDecoder;
import org.cen.robot.device.beacon.com.BeaconReadOutData;

public class BeaconDevice extends AbstractRobotDevice {
	public static final String NAME = "beacon";

	public BeaconDevice() {
		super(NAME);
	}
	
	@Override
	public void initialize(IRobotServiceProvider servicesProvider) {
		super.initialize(servicesProvider);
		IComService comService = servicesProvider.getService(IComService.class);
		comService.getDecodingService().registerDecoder(new BeaconInDataDecoder());
	}

	@Override
	protected void internalHandleRequest(RobotDeviceRequest request) {
		if (request instanceof BeaconReadRequest) {
			send(new BeaconReadOutData());
		}
	}
	
	private void send(OutData outData) {
		IComService comService = servicesProvider.getService(IComService.class);
		comService.writeOutData(outData);
	}
}
