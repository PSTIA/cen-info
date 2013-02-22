package org.cen.robot.match.strategy.test;

import org.cen.cup.cup2013.robot.match.TargetsFactory2013;
import org.cen.robot.IRobotServiceProvider;

public class TargetsFactory2013ForTest extends TargetsFactory2013 {

	public TargetsFactory2013ForTest(IRobotServiceProvider servicesProvider) {
		super(new MockRobotServiceProvider());
		
	}
	

}
