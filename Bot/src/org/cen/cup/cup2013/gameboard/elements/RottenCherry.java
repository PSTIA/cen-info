package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class RottenCherry extends Cherry {
	
	private final Color color;

	public RottenCherry(String name,double x, double y, Color color) {
		super(name, x, y);
		this.color = color;
	}

	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(color);
		DrawHelper.fillCenteredCircle(g2d, CHERRY_DIAMETER);

	}

	@Override
	public Color getCherryColor() {
		return color;
	}
}
