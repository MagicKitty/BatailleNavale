package period;

import ship.Battleship;
import ship.Carrier;
import ship.Cruiser;
import ship.Destroyer;
import ship.Submarine;

public class RenaissanceShipFactory implements IShipFactory {
	@Override
	public Carrier createCarrier() {
		return new Carrier();
	}

	@Override
	public Battleship createBattleship() {
		return new Battleship();
	}

	@Override
	public Cruiser createCruiser() {
		return new Cruiser();
	}

	@Override
	public Submarine createSubmarine() {
		return new Submarine();
	}

	@Override
	public Destroyer createDestroyer() {
		return new Destroyer();
	}
}
