package org.cen.cup.cup2013.navigation;


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


import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

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
		
		addSymmetricSplinePath(START, CHERRY_1, 0xF0, 0xC0, 250, 200);
		addSymmetricSplinePath(START, CHERRY_2, 0xF0, 0xC0, 1500-250, 200);
		addSymmetricSplinePath(START, CHERRY_3, 0xF0, 0xC0, 250, 2800);
		addSymmetricSplinePath(START, CHERRY_4, 0xF0, 0xC0, 1500-250, 2800);
		addSymmetricSplinePath(START, CHERRY_5, 0xF0, 0xC0, 1000, 2800);
		
		addSymmetricSplinePath(START, GIFT_1, 0xF0, 0xC0, 1500, (int)GIFT_POSITIONS[1]);
		addSymmetricSplinePath(START, GIFT_2, 0xF0, 0xC0, 1500, (int) GIFT_POSITIONS[2]);
		addSymmetricSplinePath(START, GIFT_3, 0xF0, 0xC0, 1500, (int) GIFT_POSITIONS[3]);
		addSymmetricSplinePath(START, GIFT_4, 0xF0, 0xC0, 1500, (int) GIFT_POSITIONS[4]);


		
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
