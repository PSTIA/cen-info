package org.cen.cup.cup2013.gameboard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;

import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class MapParty extends AbstractGameBoardElement {
	
	public static final double PLATE_AREA_HEIGHT = 400;
	public static final double LITTLE_COLORED_AREA_WIDTH = 300;
	public static final double BIG_COLORED_AREA_WIDTH = 400;
	

	public MapParty(double x, double y) {
		super("MapParty", new Point2D.Double(x, y), 0.0d);
	}

	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;

		// White
		g2d.setColor(Color2013.RAL_9016);
		DrawHelper.fillCenteredRectangle(g2d,0, -1500+PLATE_AREA_HEIGHT/2,GameBoard2013.BOARD_WIDTH, PLATE_AREA_HEIGHT);
		DrawHelper.fillCenteredRectangle(g2d,0,1500-PLATE_AREA_HEIGHT/2, GameBoard2013.BOARD_WIDTH, PLATE_AREA_HEIGHT);

		
		
		// Blue
		g2d.setColor(Color2013.RAL_5017);
		DrawHelper.fillCenteredRectangle(g2d, -750,  -1500+PLATE_AREA_HEIGHT/2, LITTLE_COLORED_AREA_WIDTH, PLATE_AREA_HEIGHT);
		DrawHelper.fillCenteredRectangle(g2d, 0,  -1500+PLATE_AREA_HEIGHT/2, BIG_COLORED_AREA_WIDTH, PLATE_AREA_HEIGHT);
		DrawHelper.fillCenteredRectangle(g2d, 750,  -1500+PLATE_AREA_HEIGHT/2, LITTLE_COLORED_AREA_WIDTH, PLATE_AREA_HEIGHT);

		// Red
		g2d.setColor(Color2013.RAL_3001);
		DrawHelper.fillCenteredRectangle(g2d, -750, 1500-PLATE_AREA_HEIGHT/2, LITTLE_COLORED_AREA_WIDTH, PLATE_AREA_HEIGHT);
		DrawHelper.fillCenteredRectangle(g2d, 0, 1500-PLATE_AREA_HEIGHT/2,  BIG_COLORED_AREA_WIDTH, PLATE_AREA_HEIGHT);
		DrawHelper.fillCenteredRectangle(g2d, 750, 1500-PLATE_AREA_HEIGHT/2, LITTLE_COLORED_AREA_WIDTH, PLATE_AREA_HEIGHT);
	}

}