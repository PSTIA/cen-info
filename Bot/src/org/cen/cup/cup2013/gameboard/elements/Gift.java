package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class Gift extends AbstractGameBoardElement {
	
	public static final double GIFT_WIDTH = 150;

	public static final double GIFT_HEIGHT = 200;
	
	public static final double GIFT_THICKNESS = 22;

	private final Color color;



	public Gift(String name, double x, double y, Color color) {
		super(name, new Point2D.Double(x, y), 0.0d);
		this.color = color;
	}
	
	
	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(color);
		DrawHelper.fillCenteredRectangle(g2d, -GIFT_WIDTH / 2, -GIFT_THICKNESS/2, GIFT_WIDTH, GIFT_THICKNESS);
	}

}
