package org.cen.cup.cup2013.robot.match;


import static org.cen.cup.cup2012.robot.match.ElementsName2012.BOTTLE_1;
import static org.cen.cup.cup2012.robot.match.ElementsName2012.BULLION_1;
import static org.cen.cup.cup2012.robot.match.ElementsName2012.BULLION_RIGHT;
import static org.cen.cup.cup2012.robot.match.ElementsName2012.DROP_1;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.DROP_1;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.HOME;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.OUT_DROP_1;

import java.awt.Point;
import java.util.Map;
import java.util.logging.Logger;

import org.cen.cup.cup2012.device.arm2012.ArmType2012;
//TODO remove arm
//import org.cen.cup.cup2013.device.arm2013.ArmDownRequest2013;
//import org.cen.cup.cup2013.device.arm2013.ArmType2013;
//import org.cen.cup.cup2013.device.arm2013.ArmUpRequest2013;
import org.cen.cup.cup2013.navigation.NavigationMap2013;
import org.cen.logging.LoggingUtils;
import org.cen.navigation.INavigationMap;
import org.cen.navigation.ITrajectoryService;
import org.cen.navigation.Location;
import org.cen.robot.IRobotServiceProvider;
import org.cen.robot.device.RobotDeviceRequest;
import org.cen.robot.device.navigation.BezierMoveRequest;
import org.cen.robot.device.navigation.RotationRequest;
import org.cen.robot.device.timer.SleepRequest;
import org.cen.robot.match.strategy.ITarget;
import org.cen.robot.match.strategy.ITargetAction;
import org.cen.robot.match.strategy.ITargetActionItemList;
import org.cen.robot.match.strategy.ITargetActionList;
import org.cen.robot.match.strategy.TargetList;
import org.cen.robot.match.strategy.impl.DefaultTargetAction;
import org.cen.robot.match.strategy.impl.SimpleTarget;
import org.cen.robot.match.strategy.impl.SimpleTargetActionItem;

public class TargetsFactory2013 {
	private static final Logger LOGGER = LoggingUtils.getClassLogger();

	private final IRobotServiceProvider servicesProvider;

	private final INavigationMap map;

	private TargetList targets;

	public TargetsFactory2013(IRobotServiceProvider servicesProvider) {
		super();
		this.servicesProvider = servicesProvider;
		ITrajectoryService trajectoryService = servicesProvider.getService(ITrajectoryService.class);
		map = trajectoryService.getNavigationMap();

		buildTargets();
	}

	private ITarget addSimpleTarget(String name, double gain) {
		Map<String, Location> locations = map.getLocationsMap();
		Location l = locations.get(name);
		if (l == null) {
			logInvalidLocation(name);
		}
		Point p = null;
		if (l != null) {
			p = l.getPosition();
		}

		SimpleTarget target = new SimpleTarget(name, p, gain);
		targets.registerTarget(target);
		return target;
	}

	private void addSleepTime(ITargetAction action, int delay) {
		RobotDeviceRequest request = new SleepRequest(delay);
		SimpleTargetActionItem item = new SimpleTargetActionItem(request);
		ITargetActionItemList items = action.getItems();
		items.addTargetActionItem(item);
	}

	private void addSplineRequest(ITargetAction action, String location, int d1, int d2, double angle) {
		Map<String, Location> locations = this.map.getLocationsMap();
		Location l = locations.get(location);
		if (l == null) {
			logInvalidLocation(location);
		}

		Point p = l.getPosition();
		d1 = NavigationMap2013.toDistance(d1);
		d2 = NavigationMap2013.toDistance(d2);
		BezierMoveRequest request = new BezierMoveRequest(p, d1, d2, angle);
		SimpleTargetActionItem item = new SimpleTargetActionItem(request);
		ITargetActionItemList items = action.getItems();
		items.addTargetActionItem(item);
	}

	private ITarget[] addSymmetricSimpleTarget(String name, double gain) {
		// red
		ITarget t1 = addSimpleTarget(NavigationMap2013.getRedName(name), gain);
		// violet
		ITarget t2 = addSimpleTarget(NavigationMap2013.getBlueName(name), gain);
		return new ITarget[] { t1, t2 };
	}

	private void addSymmetricSleepTime(ITargetAction[] a, int delay) {
		// red
		addSleepTime(a[0], delay);
		// violet
		addSleepTime(a[1], delay);
	}

	private void addSymmetricSplineRequest(ITargetAction[] actions, String location, int d1, int d2, int angle) {
		double a = NavigationMap2013.toAngle(angle);
		// red
		addSplineRequest(actions[0], NavigationMap2013.getRedName(location), d1, d2, NavigationMap2013.getSymmetricAngle(a));
		// violet
		addSplineRequest(actions[1], NavigationMap2013.getBlueName(location), d1, d2, a);
	}

	private ITargetAction[] addSymmetricTargetAction(ITarget[] targets, String start, String end, int time) {
		// red
		ITargetAction a1 = addTargetAction(targets[0], NavigationMap2013.getRedName(start), NavigationMap2013.getRedName(end),
				time);
		// violet
		ITargetAction a2 = addTargetAction(targets[1], NavigationMap2013.getBlueName(start),
				NavigationMap2013.getBlueName(end), time);
		return new ITargetAction[] { a1, a2 };
	}

	private ITargetAction addTargetAction(ITarget target, String start, String end, int time) {
		Map<String, Location> locations = map.getLocationsMap();
		Location l1 = locations.get(start);
		Location l2 = locations.get(end);
		if (l1 == null) {
			logInvalidLocation(start);
		}
		if (l2 == null) {
			logInvalidLocation(end);
		}
		DefaultTargetAction action = new DefaultTargetAction(target, l1, l2, time);
		ITargetActionList list = target.getActionList();
		list.addTargetAction(action);
		return action;
	}

	private void buildTargets() {
		// ATTENTION :
		// la symétrie se base toujours sur les coordonnées du côté BLEU

		//Reminder of the prototype of the functions to generate actions:
		//addSymmetricSimpleTarget(name, gain);
		//addSymmetricTargetAction(target, start position, end position, time to achieve);
		
		// All the GIFTS:
		targets = new TargetList();
		ITarget[] t = addSymmetricSimpleTarget(GIFT_1, 4);
		ITargetAction[] a = addSymmetricTargetAction(t, GIFT_1, GIFT_1, 5);
		
		t = addSymmetricSimpleTarget(GIFT_2, 4);
		a = addSymmetricTargetAction(t, GIFT_2, GIFT_2, 5);
		
		t = addSymmetricSimpleTarget(GIFT_3, 4);
		a = addSymmetricTargetAction(t, GIFT_3, GIFT_3, 5);
		
		t = addSymmetricSimpleTarget(GIFT_4, 4);
		a = addSymmetricTargetAction(t, GIFT_4, GIFT_4, 5);
		
		//All the cherry actions

		t = addSymmetricSimpleTarget(CHERRY_1, 16);
		a = addSymmetricTargetAction(t, CHERRY_1, CHERRY_LAUNCH_POSITION, 10);
		//addSymmetricRecoverCherry(a, ArmType2012.RIGHT);
		addSymmetricSplineRequest(a, CHERRY_LAUNCH_POSITION, 0x64, 0x32, 0xFC7C);
		//addSymmetricLunchCherry(a, ArmType2012.RIGHT);
		
		t = addSymmetricSimpleTarget(CHERRY_2, 16);
		a = addSymmetricTargetAction(t, CHERRY_2, CHERRY_LAUNCH_POSITION, 10);
		//addSymmetricRecoverCherry(a, ArmType2012.RIGHT);
		addSymmetricSplineRequest(a, CHERRY_LAUNCH_POSITION, 0x64, 0x32, 0xFC7C);
		//addSymmetricLunchCherry(a, ArmType2012.RIGHT);
		
		t = addSymmetricSimpleTarget(CHERRY_3, 16);
		a = addSymmetricTargetAction(t, CHERRY_3, CHERRY_LAUNCH_POSITION, 10);
		//addSymmetricRecoverCherry(a, ArmType2012.RIGHT);
		addSymmetricSplineRequest(a, CHERRY_LAUNCH_POSITION, 0x64, 0x32, 0xFC7C);
		//addSymmetricLunchCherry(a, ArmType2012.RIGHT);
		
		t = addSymmetricSimpleTarget(CHERRY_4, 16);
		a = addSymmetricTargetAction(t, CHERRY_4, CHERRY_LAUNCH_POSITION, 10);
		//addSymmetricRecoverCherry(a, ArmType2012.RIGHT);
		addSymmetricSplineRequest(a, CHERRY_LAUNCH_POSITION, 0x64, 0x32, 0xFC7C);
		//addSymmetricLunchCherry(a, ArmType2012.RIGHT);
		
		t = addSymmetricSimpleTarget(CHERRY_5, 16);
		a = addSymmetricTargetAction(t, CHERRY_5, CHERRY_LAUNCH_POSITION, 10);
		//addSymmetricRecoverCherry(a, ArmType2012.RIGHT);
		addSymmetricSplineRequest(a, CHERRY_LAUNCH_POSITION, 0x64, 0x32, 0xFC7C);
		//addSymmetricLunchCherry(a, ArmType2012.RIGHT);
		
		
	}

	private void addSymmetricRotation(ITargetAction[] a, int angle) {
		// red
		addRotation(a[0], angle);
		// blue
		addRotation(a[1], angle);
	}

	private void addRotation(ITargetAction action, int angle) {
		double a = NavigationMap2013.toAngle(angle);
		RobotDeviceRequest request = new RotationRequest(a);
		SimpleTargetActionItem item = new SimpleTargetActionItem(request);
		ITargetActionItemList items = action.getItems();
		items.addTargetActionItem(item);
	}



	public TargetList getTargets() {
		return targets;
	}

	protected void logInvalidLocation(String s) {
		LOGGER.severe("Unknown location: " + s);
	}
}
