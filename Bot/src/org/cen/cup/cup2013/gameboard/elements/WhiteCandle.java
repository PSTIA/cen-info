package org.cen.cup.cup2013.gameboard.elements;

import java.awt.Color;

import org.cen.cup.cup2013.gameboard.Color2013;

public class WhiteCandle extends Candle {

	public WhiteCandle(String name, double x, double y) {
		super(name, x, y);
	}

	@Override
	public Color getCandleColor() {
		return Color2013.RAL_9016;
	}

}
