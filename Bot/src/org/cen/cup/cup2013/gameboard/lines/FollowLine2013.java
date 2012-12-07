package org.cen.cup.cup2013.gameboard.lines;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import org.cen.cup.cup2012.gameboard.Color2012;
import org.cen.cup.cup2012.gameboard.GameBoard2012;
import org.cen.cup.cup2012.gameboard.elements.StartArea2012;
import org.cen.ui.gameboard.AbstractGameBoardElement;

public class FollowLine2013 extends AbstractGameBoardElement {

	public static final int LINE_WIDTH = 20;

	public static final int FIRST_LINE_HEIGHT = -1400+1000;
	
	public static final int SECOND_LINE_HEIGHT = -1300+1000;
	
	public static final int THIRD_LINE_HEIGHT = -300+1000;
	
	public static final int CIRCLE_DIAMATER = 2*150;
	

	public FollowLine2013(double x, double y) {
		super("followLine2013", new Point2D.Double(x, y), 0.0d);
	}

	@Override
	public void paint(Graphics2D g2d) {

		// Black
		g2d.setColor(Color2012.RAL_9005);

		g2d.setStroke(new BasicStroke(LINE_WIDTH));
		
		// First lines
		g2d.drawLine(FIRST_LINE_HEIGHT, 1500, FIRST_LINE_HEIGHT, 1500-600+CIRCLE_DIAMATER/4);
		g2d.drawLine(FIRST_LINE_HEIGHT, -1500, FIRST_LINE_HEIGHT, -1500+600-CIRCLE_DIAMATER/4);
		
		// Second line
		g2d.drawLine(SECOND_LINE_HEIGHT, 2400-1500-CIRCLE_DIAMATER/4, SECOND_LINE_HEIGHT, -2400+1500+CIRCLE_DIAMATER/4);
		
		// Third line
		g2d.drawLine(THIRD_LINE_HEIGHT, 2400-1500-CIRCLE_DIAMATER/4, THIRD_LINE_HEIGHT, -2400+1500+CIRCLE_DIAMATER/4);
		
		// Vertical lines
		g2d.drawLine(-1400+1000+CIRCLE_DIAMATER/4, 2400-1500, 1000, 2400-1500);
		g2d.drawLine(-1400+1000+CIRCLE_DIAMATER/4, -2400+1500, 1000, -2400+1500);		
				
		// Arcs
		g2d.drawArc(THIRD_LINE_HEIGHT-CIRCLE_DIAMATER/2,-750-CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,90,-90);
		g2d.drawArc(THIRD_LINE_HEIGHT-CIRCLE_DIAMATER/2,900-CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,0,-90);
		
		g2d.drawArc(-450+CIRCLE_DIAMATER/2,900-CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,180,90);
		g2d.drawArc(-450+CIRCLE_DIAMATER/2,-750-CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,180,-90);
		
		g2d.drawArc(-550+CIRCLE_DIAMATER/2,1050-CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,180,-90);	
		g2d.drawArc(-550+CIRCLE_DIAMATER/2,-900-CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,CIRCLE_DIAMATER/2,180,90);

	}
}