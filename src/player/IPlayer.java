package player;

import game.AbstractGame;
import graphic.Coord2D;
import ship.ShipType;

public interface IPlayer {
	public ShipType chooseShip();
	public Coord2D chooseCell();
}
