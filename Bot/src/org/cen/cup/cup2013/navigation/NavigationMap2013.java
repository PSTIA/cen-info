package org.cen.cup.cup2013.navigation;



import static org.cen.cup.cup2013.robot.match.ElementsName2013.*;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import org.cen.cup.cup2012.robot.match.ElementsName2012;
import org.cen.cup.cup2013.gameboard.Color2013;
import org.cen.cup.cup2013.gameboard.GameBoard2013;

import org.cen.cup.cup2013.robot.Robot2013;
import org.cen.cup.cup2013.robot.match.ElementsName2013;
import org.cen.cup.cup2013.gameboard.GameBoard2013;
import org.cen.cup.cup2013.gameboard.elements.Gift;
import org.cen.cup.cup2013.gameboard.lines.FollowLine2013;
import org.cen.logging.LoggingUtils;
import org.cen.navigation.AbstractNavigationMap;
import org.cen.robot.match.strategy.ITarget;
import org.cen.robot.match.strategy.ITargetAction;
import org.cen.robot.match.strategy.TargetList;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Navigation map for the cup 2012.
 */
public class NavigationMap2013 extends AbstractNavigationMap implements ResourceLoaderAware {

	public static final String SUFFIX_VIOLET = "V";

	public static final String SUFFIX_RED = "R";

	private static final Logger LOGGER = LoggingUtils.getClassLogger();

	
	// Global value

	private static final double SECURITY_DISTANCE = 40;

	private static final double BIG_SECURITY_DISTANCE = 80;

	// X

	private static final double A_X = FollowLine2013.FIRST_LINE_HEIGHT;

	private static final double B_X = FollowLine2013.SECOND_LINE_HEIGHT;

	private static final double C_X = FollowLine2013.THIRD_LINE_HEIGHT;


	// Y

	private static final double Y_1 = -1500+600;

	private static final double Y_3 = GameBoard2013.BOARD_MIDDLE_HEIGHT;

	private static final double Y_2 = 1500-600;
	
	// GIFT
	
	private static final double BORDER_WIDTH = GameBoard2013.BORDER_WIDTH;
	private static final double[] GIFT_POSITIONS = GameBoard2013.GIFT_POSITIONS;
	

	public static String getOppositeName(String name) {
		if (name.endsWith(SUFFIX_VIOLET)) {
			name = name.substring(0, name.length() - SUFFIX_VIOLET.length());
			name += SUFFIX_VIOLET;
		} else if (name.endsWith(SUFFIX_VIOLET)) {
			name = name.substring(0, name.length() - SUFFIX_VIOLET.length());
			name += SUFFIX_VIOLET;
		}
		return name;
	}

	public static String getRedName(String name) {
		return name + SUFFIX_VIOLET;
	}

	public static double getSymmetricAngle(double angle) {
		return -angle;
	}

	public static String getBlueName(String name) {
		return name + SUFFIX_VIOLET;
	}

	public static double toAngle(int i) {
		if (i > 0x7FFF) {
			i -= 0x10000;
		}
		double angle = Math.toRadians(0.1 * i);
		return angle;
	}

	private ResourceLoader resourcesLoader;

	private String resourcesPath;

	private Properties robotProperties;

	/**
	 * Adds a symmetric location by appending its name with the "R" suffix for
	 * the red side and the "V" suffix for the violet side.
	 * 
	 * @param locationName
	 *            location name
	 * @param x
	 *            in VIOLET coordinates
	 * @param y
	 *            in VIOLET coordinates
	 */
	private void addSymmetricLocation(String locationName, int x, int y) {
		addLocation(locationName + SUFFIX_VIOLET, x, y);
		addLocation(locationName + SUFFIX_VIOLET, x, GameBoard2013.BOARD_HEIGHT - y);
	}

	public void addSymmetricSplinePath(String location1, String location2, int cpDistance1, int cpDistance2, int angle1,
			int angle2) {
		double a1 = toAngle(angle1);
		double a2 = toAngle(angle2);

		addSplinePath(location1 + SUFFIX_RED, location2 + SUFFIX_RED, cpDistance1, cpDistance2, getSymmetricAngle(a1),
				getSymmetricAngle(a2));
		addSplinePath(location1 + SUFFIX_VIOLET, location2 + SUFFIX_VIOLET, cpDistance1, cpDistance2, a1, a2);
	}

	private void buildGrid() {
		
		addSymmetricLocation(START,1000, 200);
		addSymmetricLocation(CHERRY_1,250, 2800);
		addSymmetricLocation(CHERRY_2,2000-250, 2800);
		addSymmetricLocation(CHERRY_3,250, 2800);
		addSymmetricLocation(CHERRY_4, 1400, 2800);
		addSymmetricLocation(CHERRY_5,600, 2800);
		addSymmetricLocation(GIFT_1,2000,  (int)GIFT_POSITIONS[0]);
		addSymmetricLocation(GIFT_2,2000,  (int)GIFT_POSITIONS[1]);
		addSymmetricLocation(GIFT_3,2000,  (int)GIFT_POSITIONS[2]);
		addSymmetricLocation(GIFT_4,2000,  (int)GIFT_POSITIONS[3]);
		addSymmetricLocation(GLASS_1, 950, 900);
		addSymmetricLocation(GLASS_2,  950, 1200);
		addSymmetricLocation(GLASS_3,1450, 900);
		addSymmetricLocation(GLASS_4, 1450, 1200);
		addSymmetricLocation(GLASS_5,  1200, 1050);
		addSymmetricLocation(GLASS_6, 1200, 1350);
		addSymmetricLocation(GLASS_7, 950,3000-900);
		addSymmetricLocation(GLASS_8,  950, 3000-1200);
		addSymmetricLocation(GLASS_9,1450, 3000-900);
		addSymmetricLocation(GLASS_10, 1450, 3000-1200);
		addSymmetricLocation(GLASS_11,  1200, 3000-1050);
		addSymmetricLocation(GLASS_12, 1200, 3000-1350);
		
		addSymmetricLocation(GLASS_BUILD_AREA, 1000, 200);
		
		
		addSymmetricSplinePath(START, CHERRY_1, 1000, 200, 250, 200);
		addSymmetricSplinePath(START, CHERRY_2, 1000, 200, 1500-250, 200);
		addSymmetricSplinePath(START, CHERRY_3, 1000, 200, 250, 2800);
		addSymmetricSplinePath(START, CHERRY_4, 1000, 200, 1500-250, 2800);
		addSymmetricSplinePath(START, CHERRY_5, 1000, 200, 1000, 2800);
		addSymmetricSplinePath(START, GIFT_1, 1000, 200, 2000, (int)GIFT_POSITIONS[0]);
		addSymmetricSplinePath(START, GIFT_2, 1000, 200, 2000, (int) GIFT_POSITIONS[1]);
		addSymmetricSplinePath(START, GIFT_3, 1000, 200, 2000, (int) GIFT_POSITIONS[2]);
		addSymmetricSplinePath(START, GIFT_4, 1000, 200, 2000, (int) GIFT_POSITIONS[3]);
		addSymmetricSplinePath(CHERRY_1, CHERRY_LAUNCH_POSITION, 250, 200, 300, 1500);
		addSymmetricSplinePath(CHERRY_2, CHERRY_LAUNCH_POSITION, 1500-250, 200, 300, 1500);
		addSymmetricSplinePath(CHERRY_3, CHERRY_LAUNCH_POSITION,250, 2800, 300, 1500);
		addSymmetricSplinePath(CHERRY_4, CHERRY_LAUNCH_POSITION, 1500-250, 2800, 300, 1500);
		addSymmetricSplinePath(CHERRY_5, CHERRY_LAUNCH_POSITION, 1000, 2800, 300, 1500);
		
		  // Glass
		  addSymmetricSplinePath(START, GLASS_1, 1000, 200, 950, 900);
		  addSymmetricSplinePath(START, GLASS_2, 1000, 200, 950, 1200);
		  addSymmetricSplinePath(START, GLASS_3, 1000, 200, 1450, 900);
		  addSymmetricSplinePath(START, GLASS_4, 1000, 200, 1450, 1200);
		  addSymmetricSplinePath(START, GLASS_5, 1000, 200, 1200, 1050);
		  addSymmetricSplinePath(START, GLASS_6, 1000, 200, 1200, 1350);
		  addSymmetricSplinePath(START, GLASS_7, 1000, 200, 950,3000-900);
		  addSymmetricSplinePath(START, GLASS_8, 1000, 200, 950, 3000-1200);
		  addSymmetricSplinePath(START, GLASS_9, 1000, 200, 1450, 3000-900);
		  addSymmetricSplinePath(START, GLASS_10, 1000, 200, 1450, 3000-1200);
		  addSymmetricSplinePath(START, GLASS_11, 1000, 200, 1200, 3000-1050);
		  addSymmetricSplinePath(START, GLASS_12, 1000, 200, 1200, 3000-1350);
		  addSymmetricSplinePath(GLASS_1, GLASS_BUILD_AREA,  950, 900,1000, 200);
		  addSymmetricSplinePath(GLASS_2, GLASS_BUILD_AREA,  950, 1200,1000, 200);
		  addSymmetricSplinePath(GLASS_3, GLASS_BUILD_AREA,1450, 900, 1000, 200);
		  addSymmetricSplinePath(GLASS_4, GLASS_BUILD_AREA, 1450, 1200,1000, 200);
		  addSymmetricSplinePath(GLASS_5, GLASS_BUILD_AREA,  1200, 1050,1000, 200);
		  addSymmetricSplinePath(GLASS_6, GLASS_BUILD_AREA,  1200, 1350,1000, 200);
		  addSymmetricSplinePath(GLASS_7, GLASS_BUILD_AREA,  950,3000-900,1000, 200);
		  addSymmetricSplinePath(GLASS_8, GLASS_BUILD_AREA,   950, 3000-1200,1000, 200);
		  addSymmetricSplinePath(GLASS_9, GLASS_BUILD_AREA, 1450, 3000-900,1000, 200);
		  addSymmetricSplinePath(GLASS_10, GLASS_BUILD_AREA,  1450, 3000-1200,1000, 200);
		  addSymmetricSplinePath(GLASS_11, GLASS_BUILD_AREA, 1200, 3000-1050,1000, 200);
		  addSymmetricSplinePath(GLASS_12, GLASS_BUILD_AREA, 1200, 3000-1350,1000, 200);

	}

	@Override
	public void addSplinePath(String location1, String location2, int cpDistance1, int cpDistance2, double angle1, double angle2) {
		cpDistance1 = toDistance(cpDistance1);
		cpDistance2 = toDistance(cpDistance2);
		super.addSplinePath(location1, location2, cpDistance1, cpDistance2, angle1, angle2);
	}

	public static int toDistance(int i) {
		if (i > 0x7F) {
			i -= 0x100;
		}
		return i;
	}

	private String getLocationName(int x, int y) {
		return (char) (x + 'A') + String.valueOf(y + 3);
	}

	private void initConfiguration() {
		robotProperties = new Properties();
		Resource resource = resourcesLoader.getResource(resourcesPath);
		try {
			InputStream is = resource.getInputStream();
			try {
				robotProperties.load(is);
			} finally {
				is.close();
			}
		} catch (Exception e) {
			LOGGER.warning("unable to load properties: " + e.getMessage());
		}
	}

	@Override
	public void reset() {
		super.reset();
		initConfiguration();
		buildGrid();
	}

	@Override
	public void setResourceLoader(ResourceLoader resourcesLoader) {
		this.resourcesLoader = resourcesLoader;
	}

	public void setResourcesPath(String resourcesPath) {
		this.resourcesPath = resourcesPath;
	}
}
