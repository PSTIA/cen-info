package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class Glass extends AbstractGameBoardElement {
	
	public static final double CANDLE_DIAMETER = 80;

	public static final double CANDLE_HEIGHT = 80;



	public static final Color GLASS_COLOR = new Color(142, 205, 225);
	
	
	public Glass(String name, double x, double y) {
		super(name, new Point2D.Double(x, y), 0.0d);
	}
	
	
	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(GLASS_COLOR);
		DrawHelper.fillCenteredCircle(g2d, CANDLE_DIAMETER);

	}

}
