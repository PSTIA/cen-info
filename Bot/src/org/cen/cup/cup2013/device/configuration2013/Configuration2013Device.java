package org.cen.cup.cup2013.device.configuration2013;

import org.cen.cup.cup2013.robot.match.ConfigurationHandler2013;
import org.cen.robot.device.configuration.ConfigurationDevice;
import org.cen.robot.device.configuration.ConfigurationReadResult;

/**
 * Specific configuration device for the cup 2013.
 */
public class Configuration2013Device extends ConfigurationDevice {
	int value = (1 << ConfigurationHandler2013.SWITCH_MATCHSIDE);

	@Override
	public void debug(String debugAction) {
		super.debug(debugAction);
		if (debugAction.equals("flagViolet")) {
			// set bit
			value |= (1 << ConfigurationHandler2013.SWITCH_MATCHSIDE);
		} else if (debugAction.equals("flagRed")) {
			// clear bit
			value &= ~(1 << ConfigurationHandler2013.SWITCH_MATCHSIDE);
		} else if (debugAction.equals("done")) {
			notifyResult(new ConfigurationReadResult(null, value));
		}
	}
}
