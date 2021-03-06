package org.cen.cup.cup2013.robot.match;

import java.util.logging.Logger;

import org.cen.cup.cup2013.navigation.NavigationMap2013;
import org.cen.cup.cup2013.robot.match.TargetsFactory2013;
import org.cen.logging.LoggingUtils;
import org.cen.robot.IRobotServiceProvider;
import org.cen.robot.match.MatchSide;
import org.cen.robot.match.strategy.IGameStrategy;
import org.cen.robot.match.strategy.IGameStrategyItemList;
import org.cen.robot.match.strategy.ITarget;
import org.cen.robot.match.strategy.TargetList;
import org.cen.robot.match.strategy.gain.factor.ComposedFactorTargetGain;
import org.cen.robot.match.strategy.impl.DefaultGameStrategy;
import org.cen.robot.match.strategy.impl.DefaultGameStrategyItem;
import org.cen.robot.match.strategy.impl.DefaultGameStrategyList;

public class GameStrategyFactory2013 {
	private static final Logger LOGGER = LoggingUtils.getClassLogger();

	private IRobotServiceProvider servicesProvider;

	private DefaultGameStrategyList strategies;

	private TargetsFactory2013 targetsFactory;

	private MatchSide side;

	public GameStrategyFactory2013(IRobotServiceProvider servicesProvider, MatchSide side) {
		super();
		this.servicesProvider = servicesProvider;
		this.side = side;
		strategies = new DefaultGameStrategyList();
		targetsFactory = new TargetsFactory2013(servicesProvider);

		buildStrategies();
	}

	private void buildStrategies() {
		// ATTENTION :
		// symétrie à partir des cibles du côté BLUE
		strategies.addStrategy(buildStrategyTest());
	}

	private IGameStrategy buildStrategyTest() {
		DefaultGameStrategy strategy = new DefaultGameStrategy("Test");
		IGameStrategyItemList items = strategy.getItems();
		//TODO remove
		/*items.addStrategyItem(new DefaultGameStrategyItem(getTarget("Bullion1V"), new ComposedFactorTargetGain()));
		items.addStrategyItem(new DefaultGameStrategyItem(getTarget("Bottle1V"), new ComposedFactorTargetGain()));
		items.addStrategyItem(new DefaultGameStrategyItem(getTarget("Bottle2V"), new ComposedFactorTargetGain()));
		items.addStrategyItem(new DefaultGameStrategyItem(getTarget("BullionRightV"), new ComposedFactorTargetGain()));
		items.addStrategyItem(new DefaultGameStrategyItem(getTarget("AfterBullionLeft1V"), new ComposedFactorTargetGain()));
		items.addStrategyItem(new DefaultGameStrategyItem(getTarget("AfterBullionLeft2V"), new ComposedFactorTargetGain()));*/
		return strategy;
	}

	public DefaultGameStrategyList getStrategies() {
		return strategies;
	}

	private ITarget getTarget(String name) {
		if (side == MatchSide.RED) {
			name = NavigationMap2013.getOppositeName(name);
		}
		TargetList targets = targetsFactory.getTargets();
		ITarget target = targets.getTarget(name);
		if (target == null) {
			logInvalidLocation(name);
		}
		return target;
	}

	public IGameStrategy getStrategy(String name) {
		for (IGameStrategy s : strategies) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	protected void logInvalidLocation(String s) {
		LOGGER.severe("Unknown location: " + s);
	}
}
