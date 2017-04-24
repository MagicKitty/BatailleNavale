package game;

import graphic.Coord2D;

import java.util.ArrayList;

import period.IShipFactory;
import player.IPlayer;
import player.PlayerType;
import ship.AbstractShip;
import ship.Orientation;
import ship.ShipType;
import cell.Grid;
import cell.ShipCell;

public abstract class AbstractGame {
	private String timePeriod;
	private String computerStrategy;
	private BattleshipGame bg;
	private IPlayer humain;
	private IPlayer computer;
	private Grid myGrid;
	private Grid ennemiGrid;
	private IShipFactory sf;
	private ArrayList<AbstractShip> aas = new ArrayList<>(5);
	
	public AbstractGame(){
		
	}

	public BattleshipGame getBg() {
		return bg;
	}

	public IPlayer getHumain() {
		return humain;
	}

	public IPlayer getComputer() {
		return computer;
	}

	public Grid getMyGrid() {
		return myGrid;
	}

	public Grid getEnnemiGrid() {
		return ennemiGrid;
	}

	public IShipFactory getSf() {
		return sf;
	}

	public ArrayList<AbstractShip> getAas() {
		return aas;
	}
	
	public void play() {
		
	}
	
	public String getGameType() {
		return null;
	}
	
	public String getTimePeriod() {
		return null;
	}
	
	public String getComputerStrategy() {
		return null;
	}
	
	public void setComputerStrategy() {
		
	}
	
	/**
	 * 
	 * @param type
	 * @param c
	 * @param ori
	 * @return false if adding the ship fails
	 */
	public boolean addShipDefault(ShipType type, Coord2D c, Orientation ori, PlayerType player ) {
		Grid concernedGrid = null;
		AbstractShip ship = null;
	
		if (player == PlayerType.COMPUTER)
			concernedGrid = getEnnemiGrid();
		else
			concernedGrid = getMyGrid();
		
		switch(type){
		case CARRIER:
			ship = sf.createCarrier();
			break;
		case BATTLESHIP:
			ship = sf.createBattleship();
			break;
		case CRUISER:
			ship = sf.createCruiser();
			break;
		case SUBMARINE:
			ship = sf.createSubmarine();
			break;
		case DESTROYER:
			ship = sf.createDestroyer();
			break;
		}
		
		if (ori == Orientation.HORIZONTAL) {
			int y = c.getY();
			
			//checking if there is already a ship or not
			for (int x = c.getX(); x < ship.getSize(); x++)
				if (concernedGrid.getCell(x, y) instanceof ShipCell)
					return false;
		} else {
			int x = c.getX();
			
			//checking if there is already a ship or not
			for (int y = c.getY(); y < ship.getSize(); y++)
				if (concernedGrid.getCell(x, y) instanceof ShipCell)
					return false;
		}
		
		aas.add(ship);
		
		if (ori == Orientation.HORIZONTAL) {
			int y = c.getY();
			
			//linking cells on the grid to the ship
			for (int x = c.getX(); x < ship.getSize(); x++)
				concernedGrid.addDefaultShipCell(x, y, ship);
		} else {
			int x = c.getX();
			
			//linking cells on the grid to the ship
			for (int y = c.getY(); y < ship.getSize(); y++)
				concernedGrid.addDefaultShipCell(x, y, ship);
		}
		
		return true;
	}
}
