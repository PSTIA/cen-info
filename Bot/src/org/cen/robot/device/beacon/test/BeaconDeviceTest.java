/**
 * 
 */
package org.cen.robot.device.beacon.test;

import static org.junit.Assert.*;

import org.cen.robot.device.beacon.BeaconDevice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author robhammer
 *
 */
public class BeaconDeviceTest {

	private BeaconDevice beaconDevice;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		beaconDevice = new BeaconDevice();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClassName() {
		Assert.assertEquals(beaconDevice.NAME, "beacon");
	}
	
	

}
