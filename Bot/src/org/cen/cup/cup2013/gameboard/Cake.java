package org.cen.cup.cup2013.gameboard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;

import org.cen.ui.gameboard.AbstractGameBoardElement;
import org.cen.ui.gameboard.elements.util.DrawHelper;

public class Cake extends AbstractGameBoardElement {
	
	public Cake(double x, double y) {
		super("MapParty", new Point2D.Double(x, y), 0.0d);
	}

	@Override
	public void paint(Graphics2D g) {
		Graphics2D g2d = g;
		int diameter =2* 500;
		
		// Pink
		g2d.setColor(Color2013.RAL_3015);
		g2d.fillArc(-1000-diameter/2,-diameter/2,diameter,diameter,-90,180);
		
		
		
		// Black
		g2d.setColor(Color2013.RAL_9005);
		diameter =2* 200;
		g2d.drawArc(-1000-diameter/2,-diameter/2,diameter,diameter,-90,180);
		diameter =2* 300;
		g2d.drawArc(-1000-diameter/2,-diameter/2,diameter,diameter,-90,180);
		diameter =2* 400;
		g2d.drawArc(-1000-diameter/2,-diameter/2,diameter,diameter,-90,180);
		diameter = 2*500;
		g2d.drawArc(-1000-diameter/2,-diameter/2,diameter,diameter,-90,180);
		
	
	}

}