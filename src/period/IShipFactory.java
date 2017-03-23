package period;

import ship.Battleship;
import ship.Carrier;
import ship.Cruiser;
import ship.Destroyer;
import ship.Submarine;

public interface IShipFactory {
	public Carrier createCarrier();
	public Battleship createBattleship();
	public Cruiser createCruiser();
	public Submarine createSubmarine();
	public Destroyer createDestroyer();
}
