package tests;

import org.junit.Assert;
import org.junit.Test;

import cell.Grid;
import game.StandardGame;
import period.Period;
import player.StrategyType;
import ship.Battleship;
import ship.Ships;

public class GridTests {

	@Test
	public void testSeaCell() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.addDefaultSeaCell(i,j);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				Assert.assertTrue(g.getCell(i,j).isSea());
	}

	@Test
	public void testShipCell() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.addDefaultShipCell(i, j, new Battleship());
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				Assert.assertTrue(g.getCell(i,j).isShip());
	}
	
}
