package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.cup.cup2012.gameboard.Color2012;
import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class Candle extends AbstractGameBoardElement {
	
	public static final double CANDLE_DIAMETER = 80;

	public static final double CANDLE_HEIGHT = 50;
	
	public static final double FLAME_DIAMETER = (63.5+66.7)/2;
	
	private final Color color;


	// RAL 3015
	public static final Color CANDLE_COLOR = new Color(232, 156, 181);
	
	public static final Color FLAME_COLOR = new Color(36, 145, 64);
	
	
	
	
	public Candle(String name, double x, double y, Color color) {
		super(name, new Point2D.Double(x, y), 0.0d);
		this.color = color;
	}
	
	
	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(CANDLE_COLOR);
		DrawHelper.fillCenteredCircle(g2d, CANDLE_DIAMETER);
		g2d.setColor(FLAME_COLOR);
		DrawHelper.fillCenteredCircle(g2d, FLAME_DIAMETER);
		
	}

}
