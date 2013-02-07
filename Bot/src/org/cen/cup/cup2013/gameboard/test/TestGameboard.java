package org.cen.cup.cup2013.gameboard.test;

import static org.junit.Assert.*;

import org.cen.cup.cup2013.gameboard.Color2013;
import org.cen.cup.cup2013.gameboard.GameBoard2013;
import org.cen.cup.cup2013.gameboard.elements.BlueCandle;
import org.junit.Test;

public class TestGameboard {
	BlueCandle blueCandle;
	GameBoard2013 gameBoard;

	public void Setup(){
		blueCandle = new BlueCandle("Candle",12,12);
	}
	
	@Test
	public void BlueCandleIsBlueTest() {
		assert(BlueCandle.FLAME_COLOR.equals(Color2013.RAL_5017));
	}
	
	@Test
	public void ElementInGameBoard() {
		
		gameBoard = new GameBoard2013();
		// 8 Gifts
		// 12 Glasses
		// 10 plates
		// 80 cherries
		// 1 Cake
		// 1 Board
		// 4 Borders
		// 1 Map
		// 1 FollowLines
		// 20 Candles
			
		assertEquals(138,gameBoard.getElements().size());
	}
	
	@Test
	public void FirstGiftPosition() {
		assert(GameBoard2013.GIFT_POSITIONS[0]==600);
	}
	
	@Test
	public void GameBoardColor() {
		assert(GameBoard2013.COLOR_BOARD_2013.equals(Color2013.RAL_1023));
	}
	
	@Test
	public void RottenCherryNumber() {
		gameBoard = new GameBoard2013();
		int number=0;
		for(int i=0;i<gameBoard.getElements().size();i++){
			if(gameBoard.getElements().get(i).getClass().equals(org.cen.cup.cup2013.gameboard.elements.RottenCherry.class)){
				number++;
			}
		}
		assertEquals(10, number);
	}
	
	@Test
	public void BlueCandleNumber() {
		gameBoard = new GameBoard2013();
		int number=0;
		for(int i=0;i<gameBoard.getElements().size();i++){
			if(gameBoard.getElements().get(i).getClass().equals(org.cen.cup.cup2013.gameboard.elements.BlueCandle.class)){
				number++;
			}
		}
		assertEquals(8, number);
	}
	
	@Test
	public void GiftNumber() {
		gameBoard = new GameBoard2013();
		int number=0;
		for(int i=0;i<gameBoard.getElements().size();i++){
			if(gameBoard.getElements().get(i).getClass().equals(org.cen.cup.cup2013.gameboard.elements.Gift.class)){
				number++;
			}
		}
		assertEquals(8, number);
	}
	
	
}