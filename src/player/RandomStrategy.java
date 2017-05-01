package player;

import java.util.Random;

import cell.Grid;
import graphic.Coord2D;
import ship.AbstractShip;
import ship.ShipType;
import ship.Ships;

public class RandomStrategy extends AbstractBasicStrategy implements IChooseCellStrategy {

	public RandomStrategy() {
		super();
	}

	@Override
	public ShipType chooseShip(Ships computerShips) {
		ShipType chosenType = getRandomShip();
		
		AbstractShip chosenShip = computerShips.getShip(chosenType);
		
		while(!(chosenShip.isAlive()) || (chosenShip.getNumberOfBullets() == 0)){
			chosenType = getRandomShip();	
			chosenShip = computerShips.getShip(chosenType);
		}
		
		return chosenType;
	}

	private ShipType getRandomShip(){
		int shipTypes = ShipType.values().length;
		
		Random r = new Random();
		return ShipType.values()[r.nextInt(shipTypes)];
	}

	@Override
	protected Coord2D chooseNewTarget(Grid humanGrid) {
		Random r = new Random();
		
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		
		Coord2D c = new Coord2D(x, y);
		
		while (!(humanGrid.isValidHit(c))){
			x = r.nextInt(10);
			y = r.nextInt(10);
			
			c = new Coord2D(x, y);
		}
		
		return c;
	}
}
