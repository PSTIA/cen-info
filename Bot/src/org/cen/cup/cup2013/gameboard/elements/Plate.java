package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.cup.cup2013.gameboard.Color2013;
import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class Plate extends AbstractGameBoardElement {
	
	public static final double PLATE_WIDTH = 170;

	public static final double PLATE_HEIGHT = 170;

	public static final double PLATE_EDGE_WIDTH = 22;

	// RAL 3015
	public static final Color PLATE_COLOR = Color2013.RAL_3015;
	// RAL 9005
	public static final Color PLATE_EDGE_COLOR = Color2013.RAL_9005;
	
	
	public Plate(String name, double x, double y) {
		super(name, new Point2D.Double(x, y), 0.0d);

	}
	
	
	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		g2d.setColor(PLATE_COLOR);
		DrawHelper.fillCenteredRectangle(g2d, 0, 0, PLATE_WIDTH, PLATE_HEIGHT);
		g2d.setColor(PLATE_EDGE_COLOR);
		DrawHelper.drawCenteredRectangle(g2d, 0, 0, (PLATE_WIDTH-PLATE_EDGE_WIDTH), (PLATE_HEIGHT-PLATE_EDGE_WIDTH));
	}

}
