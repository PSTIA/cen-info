package org.cen.cup.cup2013.gameboard;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import org.cen.cup.cup2013.gameboard.elements.BlueCandle;
import org.cen.cup.cup2013.gameboard.elements.Cherry;
import org.cen.cup.cup2013.gameboard.elements.Gift;
import org.cen.cup.cup2013.gameboard.elements.Glass;
import org.cen.cup.cup2013.gameboard.elements.Plate;
import org.cen.cup.cup2013.gameboard.elements.RedCandle;
import org.cen.cup.cup2013.gameboard.elements.RottenCherry;
import org.cen.cup.cup2013.gameboard.elements.WhiteCandle;
import org.cen.cup.cup2013.gameboard.lines.FollowLine2013;
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

	public static final double[] GIFT_POSITIONS = {600,1200,1800,2400};
	
	private final List<IGameBoardElement> elements;

	private final Rectangle2D gameplayBounds;

	private final Rectangle2D visibleBounds;
	

	/** Color of board. */
	private final Color COLOR_BOARD_2013 = Color2013.RAL_1023;

	public GameBoard2013() {
		super();
		gameplayBounds = new Rectangle2D.Double(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		visibleBounds = new Rectangle2D.Double(-100, -100, BOARD_WIDTH + 200,
				BOARD_HEIGHT + 200);
		elements = new ArrayList<IGameBoardElement>();
		addElements();
	}

	private void addElements() {
		elements.add(new Board(COLOR_BOARD_2013, GameBoard2013.BOARD_WIDTH,
				GameBoard2013.BOARD_HEIGHT));

		// Bottom border
		elements.add(new Border("border", BOARD_WIDTH + BORDER_WIDTH * 2,
				-BORDER_WIDTH, -BORDER_WIDTH, 0));
		// Left border
		elements.add(new Border("border", BOARD_HEIGHT, 0d, 0d, Math.PI / 2));
		// Up border
		elements.add(new Border("border", BOARD_WIDTH + BORDER_WIDTH * 2,
				-BORDER_WIDTH, BOARD_HEIGHT, 0));
		// Right border
		elements.add(new Border("border", BOARD_HEIGHT, BOARD_WIDTH,
				BOARD_HEIGHT, -Math.PI / 2));
		
		
		// Map
		elements.add(new MapParty(BOARD_MIDDLE_WIDTH,BOARD_MIDDLE_HEIGHT));

		// Cake
		elements.add(new Cake(BOARD_MIDDLE_WIDTH,BOARD_MIDDLE_HEIGHT));
		
		// Lines
		elements.add(new FollowLine2013(BOARD_MIDDLE_WIDTH,BOARD_MIDDLE_HEIGHT));
		
		//Candle
		addCandles();
		
		//Plate
		addPlates();

		

		// Gift
		for(int i=0;i<GIFT_POSITIONS.length;i++){
			elements.add(new Gift("gift", 2000+Gift.GIFT_THICKNESS+4*BORDER_WIDTH, GIFT_POSITIONS[i]-Gift.GIFT_WIDTH/2, Color2013.RAL_3001));
			elements.add(new Gift("gift", 2000+Gift.GIFT_THICKNESS +4*BORDER_WIDTH,  GIFT_POSITIONS[i]+Gift.GIFT_WIDTH/2, Color2013.RAL_5017));
		}
		
		// Glass
		addGlass();
	}

	private void addOpponentLocation(Point2D coordinates) {
		Opponent opponent = RobotUtils.getRobotAttribute(Opponent.class,
				servicesProvider);
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

	protected void addCandles() {
		double highRadius = 450;
		double lowRadius = 350;

		// Placement of the 12 candles on the lower part of the cake
		for (int i = 0; i < 12; i++) {
			double angleTempInDegree = 7.5 + 15 * i;
			double xTemp = highRadius
					* Math.sin(angleTempInDegree * 2 * Math.PI / 360);
			double yTemp = highRadius
					* Math.cos(angleTempInDegree * 2 * Math.PI / 360)
					+ BOARD_HEIGHT / 2;
			if (i == 0)
				elements.add(new RedCandle("redCandle" + i, xTemp, yTemp));
			else if (i >= 4 && i < 8)
				elements.add(new WhiteCandle("whiteCandle" + i, xTemp, yTemp));
			else if (i == 11)
				elements.add(new BlueCandle("blueCandle" + i, xTemp, yTemp));
			else if (i % 2 == 0)
				elements.add(new RedCandle("redCandle" + i, xTemp, yTemp));
			else
				elements.add(new BlueCandle("blueCandle" + i, xTemp, yTemp));
		}
		// Placement of the 12 candles on the upper part of the cake
		for (int i = 0; i < 8; i++) {
			double angleTempInDegree = 11.25 + 22.5 * i;
			double xTemp = lowRadius
					* Math.sin(angleTempInDegree * 2 * Math.PI / 360);
			double yTemp = lowRadius
					* Math.cos(angleTempInDegree * 2 * Math.PI / 360)
					+ BOARD_HEIGHT / 2;
			if (i == 0)
				elements.add(new RedCandle("redCandle" + i, xTemp, yTemp));
			else if (i == 11)
				elements.add(new BlueCandle("blueCandle" + i, xTemp, yTemp));
			else if (i % 2 == 0)
				elements.add(new RedCandle("redCandle" + i, xTemp, yTemp));
			else
				elements.add(new BlueCandle("blueCandle" + i, xTemp, yTemp));
		}

	}
	
	protected void addPlates() {
		
		double PlatePositions[][] = {	{250,200},
										{600,200},
										{1000,200},
										{1400,200},
										{1750,200},
										
										{250,BOARD_HEIGHT-200},
										{600,BOARD_HEIGHT-200},
										{1000,BOARD_HEIGHT-200},
										{1400,BOARD_HEIGHT-200},
										{1750,BOARD_HEIGHT-200},
									};
		//Position of the cherry related to the center of the plate
		double CherryPosition[][] = {	{-45,45},
										{45,45},
										{-45,-45},
										{45,-45},
										{45,0},
										{-45,0},
										{0,-21},
										{0,21},
			};
		
		//Creation of the plates and cherrys
		for (int i = 0; i < 10; i++) {
			
			//Plate adding
			elements.add(new Plate("plate"+i, PlatePositions[i][0], PlatePositions[i][1]));
			
			//Cherry adding
			long RottenCherryPlace= (long) Math.round((Math.random()*7));
			for (int j = 0; j < 8; j++) {
				if(RottenCherryPlace==j)
				{
					if(i<=4)
					{//On blue plate (5 firsts), rotten cherry are blue
						elements.add(new RottenCherry("cherry"+i+j , PlatePositions[i][0]+CherryPosition[j][0], PlatePositions[i][1]+CherryPosition[j][1],Color2013.RAL_5017));
					}
					else
					{//On red plate (5 lasts), rotten cherry are red
						elements.add(new RottenCherry("cherry"+i+j , PlatePositions[i][0]+CherryPosition[j][0], PlatePositions[i][1]+CherryPosition[j][1],Color2013.RAL_3001));
					}
				}
				else
				{
					elements.add(new Cherry("cherry"+i+j , PlatePositions[i][0]+CherryPosition[j][0], PlatePositions[i][1]+CherryPosition[j][1]));
				}
			}
		}
	}
	
	protected void addGlass() {
		
		//Positions of all the glass
		double GlassPosition[][] = {	
									{950,900},
									{950,1200},
									{1200,1050},
									{1200,1350},
									{1450,900},
									{1450,1200},
									};
		
		//Adding 6 glass
		for (int i = 0; i < 6; i++) {
			elements.add(new Glass("glass"+i, GlassPosition[i][0], GlassPosition[i][1]));
		}
		//And symetrics
		for (int i = 0; i < 6; i++) {
			elements.add(new Glass("glass"+i+6, GlassPosition[i][0], BOARD_HEIGHT-GlassPosition[i][1]));
		}
	}
	
}
