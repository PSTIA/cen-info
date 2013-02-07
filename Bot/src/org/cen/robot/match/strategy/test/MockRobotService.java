package org.cen.robot.match.strategy.test;

import java.awt.geom.Point2D;
import java.util.List;

import org.cen.navigation.INavigationMap;
import org.cen.navigation.ITrajectoryService;
import org.cen.navigation.Location;
import org.cen.robot.IRobotService;
import org.cen.robot.IRobotServiceProvider;
import org.cen.robot.device.RobotDeviceRequest;
import org.cen.util.Holder;
import org.springframework.beans.factory.annotation.Required;

public class MockRobotService  implements ITrajectoryService  {

	@Override
	public void setServicesProvider(IRobotServiceProvider provider) {
		// TODO Auto-generated method stub
		
	}
	public INavigationMap getNavigationMap(){
		return null;
		
	}
	@Override
	public double buildTrajectoryRequests(List<Point2D> path,
			double orientation, List<RobotDeviceRequest> requests,
			boolean backward) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Location> getPath(Location start, Location end) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Location> getPath(Location start, Location end,
			Holder<Integer> cost) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Location> getPath(Point2D origin, Point2D destination) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Point2D> getPathFromLocations(List<Location> currentPath) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Deprecated
	public List<RobotDeviceRequest> getRequests(List<Location> path) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getRotationAngleThreshold() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	@Required
	public void setNavigationMap(INavigationMap map) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setRotationAngleThreshold(double rotationAngleThreshold) {
		// TODO Auto-generated method stub
		
	}

}
