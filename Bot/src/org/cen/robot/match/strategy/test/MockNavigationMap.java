package org.cen.robot.match.strategy.test;

import static org.cen.cup.cup2013.robot.match.ElementsName2013.CHERRY_1;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.CHERRY_2;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.CHERRY_3;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.CHERRY_4;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.CHERRY_5;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.GIFT_1;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.GIFT_2;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.GIFT_3;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.GIFT_4;
import static org.cen.cup.cup2013.robot.match.ElementsName2013.START;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.cen.navigation.INavigationMap;
import org.cen.navigation.IPathVector;
import org.cen.navigation.Location;

public class MockNavigationMap implements INavigationMap{

	@Override
	public void addLocation(Location l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPath(String... locations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVector(IPathVector v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPathVector addVector(Location l1, Location l2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decayWeights(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Location> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Location> getLocationsMap() {
		// TODO Auto-generated method stub
		Map<String, Location> map = new HashMap<String, Location>();
		map.put("Gift1V",new Location("Gift1V",1000, 200));
		map.put("Gift2V",new Location("Gift2V",1000, 200));
		map.put("Gift3V",new Location("Gift3V",1000, 200));
		map.put("Gift4V",new Location("Gift4V",1000, 200));
		
		map.put("Cherry1V",new Location("Cherry1V",1000, 200));
		map.put("Cherry2V",new Location("Cherry2V",1000, 200));
		map.put("Cherry3V",new Location("Cherry3V",1000, 200));
		map.put("Cherry4V",new Location("Cherry4V",1000, 200));
		map.put("Cherry5V",new Location("Cherry5V",1000, 200));
		
		map.put("Cherry_Launch_PositionV",new Location("Cherry_Launch_PositionV",1000, 200));
		
		return map;
	}

	@Override
	public Location getNearestLocation(Point2D coordinates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPathVector getPathVector(Location l1, Location l2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IPathVector> getPathVectors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWeights(Point2D position, double radius,
			int additionalWeight, int maxWeight) {
		// TODO Auto-generated method stub
		
	}

}
