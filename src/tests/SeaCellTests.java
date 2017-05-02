package tests;

import org.junit.Assert;
import org.junit.Test;

import cell.Grid;
import cell.SeaCell;
import game.StandardGame;
import period.Period;
import player.StrategyType;

public class SeaCellTests {

	@Test
	public void testHitValid0() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		SeaCell sc = new SeaCell(0,0,g,false);
		sc.hit(0.);
		Assert.assertTrue(g.getCell(0,0).isValidHit());
		Assert.assertTrue(g.getNumberOfSeaShots()==1);
	}

	@Test
	public void testHitValid2000() {
		StandardGame sg = new StandardGame(Period.MODERN, StrategyType.RANDOM);
		Grid g = new Grid(sg);
		SeaCell sc = new SeaCell(0,0,g,false);
		sc.hit(2000.);
		Assert.assertTrue(g.getCell(0,0).isValidHit());
		Assert.assertTrue(g.getNumberOfSeaShots()==1);
	}
}
