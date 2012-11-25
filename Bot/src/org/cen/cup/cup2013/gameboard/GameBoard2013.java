package org.cen.cup.cup2013.gameboard;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cen.cup.cup2012.gameboard.elements.BlackCoin;
import org.cen.cup.cup2012.gameboard.elements.Bottle;
import org.cen.cup.cup2012.gameboard.elements.Bullion;
import org.cen.cup.cup2012.gameboard.elements.StartArea2012;
import org.cen.cup.cup2012.gameboard.elements.Totem;
import org.cen.cup.cup2012.gameboard.elements.WhiteCoin;
import org.cen.cup.cup2012.gameboard.lines.FollowLine2012;
import org.cen.cup.cup2013.gameboard.elements.Candle;
import org.cen.cup.cup2013.gameboard.elements.Cherry;
import org.cen.cup.cup2013.gameboard.elements.Gift;
import org.cen.cup.cup2013.gameboard.elements.Glass;
import org.cen.cup.cup2013.gameboard.elements.Plate;
import org.cen.cup.cup2013.gameboard.elements.RottenCherry;
import org.cen.robot.RobotUtils;
import org.cen.robot.match.Opponent;
import org.cen.ui.gameboard.AbstractGameBoard;
import org.cen.ui.gameboard.GameBoardClickEvent;
import org.cen.ui.gameboard.IGameBoardElement;
import org.cen.ui.gameboard.IGameBoardEvent;
import org.cen.ui.gameboard.elements.Board;
import org.cen.ui.gameboard.elements.Border;

/**
 * Gameboard for the cup 2012.
 */
public class GameBoard2013 extends AbstractGameBoard {

	public static final double BOARD_HEIGHT = 3000d;

	public static final double BOARD_WIDTH = 2000d;

	public static final double BOARD_MIDDLE_HEIGHT = BOARD_HEIGHT / 2.0d;

	public static final double BOARD_MIDDLE_WIDTH = BOARD_WIDTH / 2.0d;

	public static final double BORDER_WIDTH = 22d;

	private final List<IGameBoardElement> elements;

	private final Rectangle2D gameplayBounds;

	private final Rectangle2D visibleBounds;

	/** Color of board. */
	private final Color COLOR_BOARD_2013 = Color2013.RAL_1023;

	public GameBoard2013() {
		super();
		gameplayBounds = new Rectangle2D.Double(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		visibleBounds = new Rectangle2D.Double(-100, -100, BOARD_WIDTH + 200, BOARD_HEIGHT + 200);
		elements = new ArrayList<IGameBoardElement>();
		addElements();
	}

	private void addElements() {
		elements.add(new Board(COLOR_BOARD_2013, GameBoard2013.BOARD_WIDTH, GameBoard2013.BOARD_HEIGHT));
		
		// Bottom border
		elements.add(new Border("border", BOARD_WIDTH + BORDER_WIDTH * 2, -BORDER_WIDTH, -BORDER_WIDTH, 0));
		// Left border
		elements.add(new Border("border", BOARD_HEIGHT, 0d, 0d, Math.PI / 2));
		// Up border
		elements.add(new Border("border", BOARD_WIDTH + BORDER_WIDTH * 2, -BORDER_WIDTH, BOARD_HEIGHT, 0));
		// Right border
		elements.add(new Border("border", BOARD_HEIGHT, BOARD_WIDTH, BOARD_HEIGHT, -Math.PI / 2));

		elements.add(new FollowLine2012());
		
		// Test Red Candle
		elements.add(new Candle("candle", 1500, 1000, Color2013.RAL_3001));
		// Test Blue Candle
		elements.add(new Candle("candle", 1500, 1100, Color2013.RAL_5017));
		
		// Test Cherry
		elements.add(new Cherry("cherry", 1350, 1000));
		// Test Red Rotten Cherry
		elements.add(new RottenCherry("rotten cherry", 1380, 1000,Color2013.RAL_3001));
		// Test Blue Rotten Cherry
		elements.add(new RottenCherry("rotten cherry", 1400, 1000,Color2013.RAL_5017));
		
		// Test Red Gift
		elements.add(new Gift("gift", 1000, 900,Color2013.RAL_3001));
		// Test Blue Gift
		elements.add(new Gift("gift", 1000, 900,Color2013.RAL_5017));
		
		// Test Glass
		elements.add(new Glass("gift", 1300, 900));
		
		// Test Plate
		elements.add(new Plate("gift", 700, 1000));
	}

	private void addOpponentLocation(Point2D coordinates) {
		Opponent opponent = RobotUtils.getRobotAttribute(Opponent.class, servicesProvider);
		opponent.addLocation(coordinates);
	}

	@Override
	public List<IGameBoardElement> getElements() {
		return elements;
	}

	@Override
	public Rectangle2D getGameplayBounds() {
		return gameplayBounds;
	}

	@Override
	public Rectangle2D getVisibleBounds() {
		return visibleBounds;
	}

	@Override
	protected boolean handleEvent(IGameBoardEvent event) {
		if (event instanceof GameBoardClickEvent) {
			GameBoardClickEvent e = (GameBoardClickEvent) event;
			// addOpponentLocation(e.getCoordinates());
			// stoppe la propagation de l'événement
			// return true;
		}
		return false;
	}
}
