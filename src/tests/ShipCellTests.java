package tests;

import org.junit.Assert;
import org.junit.Test;

import cell.Grid;
import cell.ShipCell;
import game.StandardGame;
import period.ModernShipFactory;
import period.Period;
import player.StrategyType;

public class ShipCellTests {

	@Test
	public void testHitValid5() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		ModernShipFactory msf = new ModernShipFactory();
		ShipCell sc = new ShipCell(0, 0, g, msf.createBattleship(), 5.);
		sc.hit(5.);
		Assert.assertTrue(g.getCell(0,0).isValidHit());
	}

	@Test
	public void testHitValid0() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		ModernShipFactory msf = new ModernShipFactory();
		ShipCell sc = new ShipCell(0, 0, g, msf.createBattleship(), 5.);
		sc.hit(0.);
		Assert.assertTrue(g.getCell(0,0).isValidHit());
	}
	
	@Test
	public void testHitValid2000() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		ModernShipFactory msf = new ModernShipFactory();
		ShipCell sc = new ShipCell(0, 0, g, msf.createBattleship(), 5.);
		sc.hit(2000.);
		Assert.assertTrue(g.getCell(0,0).isValidHit());
	}
	
	@Test
	public void testHitIsAlive5() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		ModernShipFactory msf = new ModernShipFactory();
		ShipCell sc = new ShipCell(0, 0, g, msf.createBattleship(), 5.);
		sc.hit(5.);
		Assert.assertTrue(!g.getCell(0,0).isAlive());
	}
	
	@Test
	public void testHitIsAlive0() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		ModernShipFactory msf = new ModernShipFactory();
		ShipCell sc = new ShipCell(0, 0, g, msf.createBattleship(), 5.);
		sc.hit(0.);
		Assert.assertTrue(sc.isAlive());
	}
}
