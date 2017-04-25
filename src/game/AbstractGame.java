package game;

import java.util.ArrayList;

import cell.Grid;
import cell.ShipCell;
import graphic.Coord2D;
import period.FutureShipFactory;
import period.IShipFactory;
import period.ModernShipFactory;
import period.Period;
import period.RenaissanceShipFactory;
import player.ComputerPlayer;
import player.CrossStrategy;
import player.HumanPlayer;
import player.IPlayer;
import player.PlayerType;
import player.RandomStrategy;
import player.StrategyType;
import ship.AbstractShip;
import ship.Orientation;
import ship.ShipType;

public abstract class AbstractGame {
	private Period timePeriod;
	private StrategyType computerStrategy;
	private BattleshipGame bg = null;
	private HumanPlayer humain;
	private ComputerPlayer computer;
	private Grid myGrid;
	private Grid ennemiGrid;
	private IShipFactory sf;
	private ArrayList<AbstractShip> aas = new ArrayList<>(5);
	
	public AbstractGame(Period p, StrategyType strategy){
		
		timePeriod = p;
		
		switch(timePeriod){
		case FUTURE:
			sf = new FutureShipFactory();
			break;
		case MODERN:
			sf = new ModernShipFactory();
			break;
		case RENAISSANCE:
			sf = new RenaissanceShipFactory();
			break;
		}
		
		humain = new HumanPlayer();
		computer = new ComputerPlayer();
		
		computerStrategy = strategy;
		
		switch(computerStrategy){
		case RANDOM:
			computer.setStrategy(new RandomStrategy());
			break;
		case CROSS:
			computer.setStrategy(new CrossStrategy());
			break;
		}
		
		myGrid = new Grid(this);
		ennemiGrid = new Grid(this);
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
	 * adding a ship to the game and by extension to the grid
	 * @param type the type of the ship wanted
	 * @param c the cord of the top-left corner of the ship
	 * @param ori orientation of the ship
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
		
		int xCord = c.getX();
		int yCord = c.getY();
		
		if (xCord < 0 || xCord >= 10 || yCord < 0 || yCord >= 10)
			return false;
		
		if (ori == Orientation.HORIZONTAL) {
			if (xCord + ship.getSize() >= 10)
				return false;
			
			//checking if there is already a ship or not
			for (int x = xCord; x < ship.getSize(); x++)
				if (concernedGrid.getCell(x, yCord) instanceof ShipCell)
					return false;
		} else {
			if (yCord + ship.getSize() >= 10)
				return false;
			
			//checking if there is already a ship or not
			for (int y = yCord; y < ship.getSize(); y++)
				if (concernedGrid.getCell(xCord, y) instanceof ShipCell)
					return false;
		}
		
		aas.add(ship);
		
		if (ori == Orientation.HORIZONTAL) {
			//linking cells on the grid to the ship
			for (int x = xCord; x < ship.getSize(); x++)
				concernedGrid.addDefaultShipCell(x, yCord, ship);
		} else {
			//linking cells on the grid to the ship
			for (int y = yCord; y < ship.getSize(); y++)
				concernedGrid.addDefaultShipCell(xCord, y, ship);
		}
		
		return true;
	}
}
