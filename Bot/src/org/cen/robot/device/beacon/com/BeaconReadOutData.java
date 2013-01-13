package org.cen.robot.device.beacon.com;

import org.cen.com.out.OutData;

public class BeaconReadOutData extends OutData {
	
	private static final String HEADER = "b";
	
	@Override
	public String getHeader() {
		return HEADER;
	}
}
