package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class Cherry extends AbstractGameBoardElement {
	
	public static final double CHERRY_DIAMETER = 40;


	//  RAL 9016
	public static final Color CHERRY_COLOR = new Color(252, 255, 255);


	public Cherry(String name, double x, double y) {
		super(name, new Point2D.Double(x, y), 0.0d);
	}
	
	
	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(CHERRY_COLOR);
		DrawHelper.fillCenteredCircle(g2d, CHERRY_DIAMETER);

	}
	
	public Color getCherryColor() {
		return CHERRY_COLOR;
	}

}
