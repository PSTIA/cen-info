package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class Plate extends AbstractGameBoardElement {
	
	public static final double PLATE_WIDTH = 170;

	public static final double PLATE_HEIGHT = 22;

	public static final double PLATE_EDGE_WIDTH = 22;

	// RAL 3015
	public static final Color PLATE_COLOR = new Color(232, 156, 181);
		
	// RAL 9005
	public static final Color PLATE_EDGE_COLOR = new Color(3, 5, 10);
		
	
	public Plate(String name, double x, double y) {
		super(name, new Point2D.Double(x, y), 0.0d);

	}
	
	
	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(PLATE_COLOR);
		DrawHelper.fillCenteredRectangle(g2d, -PLATE_WIDTH / 2, -PLATE_HEIGHT/2, PLATE_WIDTH, PLATE_HEIGHT);
		g2d.setColor(PLATE_EDGE_COLOR);
		DrawHelper.drawCenteredRectangle(g2d, -(PLATE_WIDTH-PLATE_EDGE_WIDTH) / 2, -(PLATE_HEIGHT-PLATE_EDGE_WIDTH)/2, (PLATE_WIDTH-PLATE_EDGE_WIDTH), (PLATE_HEIGHT-PLATE_EDGE_WIDTH));
	}

}
