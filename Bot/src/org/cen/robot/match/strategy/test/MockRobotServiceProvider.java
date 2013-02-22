package org.cen.robot.match.strategy.test;

import org.cen.robot.IRobotService;
import org.cen.robot.RobotServiceProvider;

public class MockRobotServiceProvider extends RobotServiceProvider{

	public <E extends IRobotService> E getService(Class<E> serviceType) {
		return (E) new MockRobotService();
	}
}
