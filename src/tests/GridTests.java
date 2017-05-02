package tests;

import org.junit.Assert;
import org.junit.Test;

import cell.Grid;
import game.StandardGame;
import graphic.Coord2D;
import period.ModernShipFactory;
import period.Period;
import player.StrategyType;
import ship.Battleship;

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
		ModernShipFactory msf = new ModernShipFactory();
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.addDefaultShipCell(i, j, msf.createBattleship());
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				Assert.assertTrue(g.getCell(i,j).isShip());
	}
	
	@Test
	public void testShipHit() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		ModernShipFactory msf = new ModernShipFactory();
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.addDefaultShipCell(i, j, msf.createBattleship());
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.hit(new Coord2D(i, j), 0.);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				Assert.assertTrue(g.getCell(i,j).isValidHit());
	}
	
	@Test
	public void testVisibleCells() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.addDefaultShipCell(i, j, new Battleship());
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				Assert.assertTrue(!g.getCell(i,j).isVisible());
	}
	
	@Test
	public void testShipAlive() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		ModernShipFactory msf = new ModernShipFactory();
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.addDefaultShipCell(i, j, msf.createBattleship());
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				g.hit(new Coord2D(i, j), 2000.);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				Assert.assertTrue(!g.getCell(i,j).isAlive());
	}
}
