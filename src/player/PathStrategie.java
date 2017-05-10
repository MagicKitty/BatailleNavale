package player;

import java.util.Random;

import cell.Grid;
import graphic.Coord2D;
import ship.AbstractShip;
import ship.ShipType;
import ship.Ships;

public class PathStrategie extends AbstractBasicStrategy implements IChooseCellStrategy {

	private boolean started = false;
	private int x;
	private int y;

	public PathStrategie() {
		super();
	}

	@Override
	protected Coord2D chooseNewTarget(Grid humanGrid) {
		Coord2D c = null;

		if (!started) {
			Random r = new Random();
			x = r.nextInt(10);
			y = r.nextInt(10);

			c = new Coord2D(x, y);

			while (!(humanGrid.isValidHit(c))) {
				x = r.nextInt(10);
				y = r.nextInt(10);

				c = new Coord2D(x, y);
			}

		} else {
			Random r = new Random();
			bigloop: while (true) {
				int choice = r.nextInt(4);

				if (choice == 0 && humanGrid.isValidHit(new Coord2D(x, (y + 1)))) {
					// haut
					y = y + 1;
				} else if (choice == 1 && humanGrid.isValidHit(new Coord2D(x, (y - 1)))) {
					// bas
					y = y - 1;
				} else if (choice == 2 && humanGrid.isValidHit(new Coord2D((x - 1), y))) {
					// gauche
					x = x - 1;
				} else if (choice == 3 && humanGrid.isValidHit(new Coord2D((x + 1), y))) {
					// droite
					x = x + 1;
				} else {
					started = false;
					return chooseNewTarget(humanGrid);
				}

				c = new Coord2D(x, y);
				if ((humanGrid.isValidHit(c)))
					break bigloop;
			}

		}
		return c;
	}

	@Override
	public ShipType chooseShip(Ships computerShips) {
		ShipType chosenType = getRandomShip();

		AbstractShip chosenShip = computerShips.getShip(chosenType);

		while (!(chosenShip.isAlive()) || (chosenShip.getNumberOfBullets() == 0)) {
			chosenType = getRandomShip();
			chosenShip = computerShips.getShip(chosenType);
		}

		return chosenType;
	}

	private ShipType getRandomShip() {
		int shipTypes = ShipType.values().length;

		Random r = new Random();
		return ShipType.values()[r.nextInt(shipTypes)];
	}
}
