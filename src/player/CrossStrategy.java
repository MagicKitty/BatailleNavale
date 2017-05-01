package player;

import java.util.Random;

import cell.Grid;
import graphic.Coord2D;
import ship.AbstractShip;
import ship.ShipType;
import ship.Ships;

public class CrossStrategy extends AbstractBasicStrategy implements IChooseCellStrategy {

	private int shipCounter;
	private int crossCounter;
	private boolean reverse;
	
	public CrossStrategy() {
		super();
		
		shipCounter = 0;
		crossCounter = 0;
		reverse = false;
	}

	@Override
	public ShipType chooseShip(Ships computerShips) {
		ShipType chosenType = getFirstShip();
		
		AbstractShip chosenShip = computerShips.getShip(chosenType);
		
		while(!(chosenShip.isAlive()) || (chosenShip.getNumberOfBullets() == 0)){
			shipCounter++;
			chosenType = getFirstShip();	
			chosenShip = computerShips.getShip(chosenType);
		}
		
		return chosenType;
	}

	private ShipType getFirstShip(){
		return ShipType.values()[shipCounter];
	}
	
	@Override
	protected Coord2D chooseNewTarget(Grid humanGrid) {
		Coord2D c = getCrossCoord();
		
		while(!(humanGrid.isValidHit(c))){
			crossCounter++;
			c = getCrossCoord();
		}
		
		return c;
	}

	private Coord2D getCrossCoord() {
		int x = 0;
		int y = 0;
		
		if (crossCounter >= 10){
			if (reverse){
				return getRandomCoord();
			} else {
				crossCounter = 0;
				reverse = true;
			}
		}
		
		if (reverse)
			x = 9 - crossCounter;
		else
			x = crossCounter;
		
		y = crossCounter;
		
		return new Coord2D(x, y);
	}

	private Coord2D getRandomCoord() {
		Random r = new Random();
		
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		
		return new Coord2D(x, y);
	}

}
