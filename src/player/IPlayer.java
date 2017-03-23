package player;

import game.AbstractGame;
import graphic.Coord2D;

public interface IPlayer {
	public String chooseShip();
	public Coord2D chooseCell();
}
