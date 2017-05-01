package player;

import com.sun.javafx.scene.traversal.Direction;

import cell.AbstractCell;
import cell.Grid;
import cell.SeaCell;
import cell.ShipCell;
import graphic.Coord2D;
import ship.Orientation;
import ship.ShipType;
import ship.Ships;

public abstract class AbstractBasicStrategy implements IChooseCellStrategy {
	
	private Coord2D lastCoord;
	private Coord2D lastShipCoord;
	private Coord2D firstShipCoord;
	private boolean shipFound;
	private Direction direction;
	private Orientation orientation;
	private boolean searchedInTheOtherDirection;
	
	
	public AbstractBasicStrategy() {
		lastCoord = null;
		lastShipCoord = null;
		shipFound = false;
		direction = Direction.NEXT;
		orientation = null;
		searchedInTheOtherDirection = false;
	}

	@Override
	public Coord2D chooseCell(Grid humanGrid){
		AbstractCell lastCell = humanGrid.getCell(lastCoord);
		
		if (!shipFound){ //no ship found
			if ((lastCoord == null) || (lastCell instanceof SeaCell)){ //first shot or last shot landed in the sea
				return chooseNewTarget(humanGrid);	
			} else { //the neighbor found is a ShipCell
				shipFound = true;
				
				lastShipCoord = firstShipCoord = lastCoord;
				if (humanGrid.isValidHit(lastCoord)) { //last ship cell found is not dead yet
					return lastCoord;
				} else { //last ship cell found is dead, searching for another one
					return searchNeighbor(humanGrid, true);
				}
			}
		} else { //ship already found
			if (lastCell instanceof SeaCell){//the neighbor found is a SeaCell
				return searchNeighbor(humanGrid, false);
			} else {//the neighbor found is a ShipCell
				lastShipCoord = lastCoord;
				if (humanGrid.isValidHit(lastCoord)) { //last ship cell found is not dead yet
					return lastCoord;
				} else { //last ship cell found is dead, searching for another one
					return searchNeighbor(humanGrid, true);
				}
			}
		}
	}
	
	private Coord2D searchNeighbor(Grid humanGrid, boolean lastShotOnShip){
		Coord2D c = searchingNeighbor(humanGrid, lastShotOnShip);
		
		while (!(humanGrid.isValidHit(c))){
			c = searchingNeighbor(humanGrid, false);
		}
		
		return c;
	}
	
	private Coord2D searchingNeighbor(Grid humanGrid, boolean lastShotOnShip) {
		int xLastShip = lastShipCoord.getX();		
		int xFirstShip = firstShipCoord.getX();
		
		if (lastShipCoord.equals(firstShipCoord)){ //need to find a neighbor
			if (incrementDirection())
				return lastShipCoord.getNeighbor(direction);
			else
				return noNeighbors(humanGrid);
		} else { //found a neighbor, need to find the rest of the ship
			if (orientation == null){ //only found 2 cells of the ship, need to continue in the same direction
				if (xLastShip != xFirstShip){ //determining the orientation of the ship
					orientation = Orientation.HORIZONTAL;
				} else {
					orientation = Orientation.VERTICAL;
				}
				return lastShipCoord.getNeighbor(direction);
			} else if (orientation != null && !searchedInTheOtherDirection)  { //searched in 3 cells or more in the same direction
				if (lastShotOnShip){ //previous shot landed on the ship, continue
					return lastShipCoord.getNeighbor(direction);
				} else {
					searchedInTheOtherDirection = true;
					setOppositeDirection();
					return firstShipCoord.getNeighbor(direction);
				}
			} else {
				if (lastShotOnShip){
					return firstShipCoord.getNeighbor(direction);
				} else {
					return noNeighbors(humanGrid);
				}
			}
		}		
	}

	

	protected abstract Coord2D chooseNewTarget(Grid humanGrid);

	@Override
	public abstract ShipType chooseShip(Ships computerShips);
	
	private boolean incrementDirection(){
		switch (direction){
		case LEFT:
			direction = Direction.DOWN;
			return true;
		case DOWN:
			direction = Direction.RIGHT;
			return true;
		case RIGHT:
			direction = Direction.UP;
			return true;
		case UP:
			direction = Direction.NEXT;
			return false;
		case NEXT:
			direction = Direction.LEFT;
			return true;
		default:
			return false;
		}
	}
	
	private void setOppositeDirection() {
		switch (direction){
		case LEFT:
			direction = Direction.RIGHT;
			break;
		case DOWN:
			direction = Direction.UP;
			break;
		case RIGHT:
			direction = Direction.LEFT;
			break;
		case UP:
			direction = Direction.DOWN;
			break;
		}
	}

	private Coord2D noNeighbors(Grid humanGrid){
		orientation = null;
		lastShipCoord = null;
		firstShipCoord = null;
		shipFound = false;
		direction = Direction.NEXT;
		searchedInTheOtherDirection = false;
		
		return chooseNewTarget(humanGrid);
	}
}
