package player;

import cell.Grid;
import graphic.Coord2D;
import ship.ShipType;
import ship.Ships;

public interface IChooseCellStrategy {
	public Coord2D chooseCell(Grid humanGrid);
	public ShipType chooseShip(Ships computerShips);
}
