package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.cup.cup2013.gameboard.Color2013;
import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public abstract class Candle extends AbstractGameBoardElement {
	
	public static final double CANDLE_DIAMETER = 80;

	public static final double CANDLE_HEIGHT = 50;
	
	public static final double FLAME_DIAMETER = (63.5+66.7)/2;
	


	// RAL 3015
	public static final Color FLAME_COLOR = Color2013.RAL_6018;
	
	
	
	
	public Candle(String name, double x, double y) {
		super(name, new Point2D.Double(x, y), 0.0d);
	}
	
	
	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(getCandleColor());
		DrawHelper.fillCenteredCircle(g2d, CANDLE_DIAMETER);
		g2d.setColor(FLAME_COLOR);
		DrawHelper.fillCenteredCircle(g2d, FLAME_DIAMETER);
		
	}
	public abstract Color getCandleColor();

}
