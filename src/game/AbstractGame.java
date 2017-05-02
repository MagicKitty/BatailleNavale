package game;

import java.util.ArrayList;

import cell.Grid;
import cell.ShipCell;
import cell.ShipCellData;
import graphic.Coord2D;
import period.FutureShipFactory;
import period.IShipFactory;
import period.ModernShipFactory;
import period.Period;
import period.RenaissanceShipFactory;
import player.ComputerPlayer;
import player.CrossStrategy;
import player.PlayerType;
import player.RandomStrategy;
import player.StrategyType;
import ship.AbstractShip;
import ship.Orientation;
import ship.ShipType;
import ship.Ships;

public abstract class AbstractGame {
	private Period timePeriod;
	private StrategyType computerStrategy;
	@SuppressWarnings("unused")
	private BattleshipGame bg = null;
	private ComputerPlayer computer;
	private Grid humanGrid;
	private Grid computerGrid;
	private IShipFactory sf;
	private Ships humanShips, computerShips;
	
	/**
	 * initializing the game with new grids, a specfic factory and a specific strategy for the computer
	 * @param p period selected for the ships' factory
	 * @param strategy computer's strategy selected
	 */
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
		
		computer = new ComputerPlayer(this);
		
		computerStrategy = strategy;
		
		switch(computerStrategy){
		case RANDOM:
			computer.setStrategy(new RandomStrategy());
			break;
		case CROSS:
			computer.setStrategy(new CrossStrategy());
			break;
		}
		
		humanGrid = new Grid(this);
		computerGrid = new Grid(this);
		
		computerShips = new Ships();
		humanShips = new Ships();
		
		computer.placeShips();
	}

	/**
	 * @return the type of the game (Advanced or Standard)
	 */
	public abstract GameType getGameType();
	
	/**
	 * @return the time period which is used
	 */
	public Period getTimePeriod(){
		return timePeriod;
	}
	
	/**
	 * @return the computer's strategy type which is used
	 */
	public StrategyType getComputerStrategy() {
		return computerStrategy;
	}
	
	/**
	 * setting the strategy of the computer
	 * @param strategy the type of the strategy (Cross or Random)
	 */
	public void setComputerStrategy(StrategyType strategy) {
		computerStrategy = strategy;
		
		switch(computerStrategy){
		case RANDOM:
			computer.setStrategy(new RandomStrategy());
			break;
		case CROSS:
			computer.setStrategy(new CrossStrategy());
			break;
		}
	}

	/**
	 * @return the grid of the human player
	 */
	public Grid getHumanGrid() {
		return humanGrid;
	}

	/**
	 * @return the grid of the computer
	 */
	public Grid getComputerGrid() {
		return computerGrid;
	}
	
	/**
	 * @return computer's ships
	 */
	public Ships getComputerShips(){
		return computerShips;
	}
	
	/**
	 * @return computer player
	 */
	protected ComputerPlayer getComputerPlayer(){
		return computer;
	}
	
	/**
	 * playing one turn
	 * @param humanTarget the target choosed by the human player
	 */
	public abstract void play(Coord2D humanTarget);

	/**
	 * getting a specific ship
	 * @param type the type of the ship
	 * @param player which player own the ship
	 * @return the ship of the player and of the type asked
	 */
	public AbstractShip getShip(ShipType type, PlayerType player) {
		
		Ships concernedShips = null;
		
		switch(player){
		case COMPUTER:
			concernedShips = computerShips;
			break;
		case HUMAN:
			concernedShips = humanShips;
			break;
		}
		
		return concernedShips.getShip(type);
	}
	
	/**
	 * setting a ship to a specific player
	 * @param type the type of the ship
	 * @param ship the ship itself
	 * @param player the player which will own the ship
	 */
	private void setShip(ShipType type, AbstractShip ship, PlayerType player) {
		Ships concernedShips = null;
		
		switch(player){
		case COMPUTER:
			concernedShips = computerShips;
			break;
		case HUMAN:
			concernedShips = humanShips;
			break;
		}
		
		concernedShips.setShip(type, ship);
	}
	
	/**
	 * adding a new ship to the game and by extension to the grid
	 * @param type the type of the ship wanted
	 * @param c the cord of the top-left corner of the ship
	 * @param ori orientation of the ship
	 * @param player player concerned by the adding
	 * @return false if adding the ship fails
	 */
	public boolean addShipDefault(ShipType type, Coord2D c, Orientation ori, PlayerType player ) {
		
		Grid concernedGrid = null;
		AbstractShip ship = null;
	
		if (player == PlayerType.COMPUTER)
			concernedGrid = getComputerGrid();
		else
			concernedGrid = getHumanGrid();
		
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
		
		ship.setPosition(c);
		ship.setOrientation(ori);
		setShip(type, ship, player);
		
		if (ori == Orientation.HORIZONTAL) {
			//linking cells on the grid to the ship
			for (int x = xCord; x < ship.getSize() + xCord; x++)
				concernedGrid.addDefaultShipCell(x, yCord, ship);
		} else {
			//linking cells on the grid to the ship
			for (int y = yCord; y < ship.getSize() + yCord; y++)
				concernedGrid.addDefaultShipCell(xCord, y, ship);
		}
		
		
		return true;
	}
	
	/**
	 * adding an existing ship
	 * @param type the type of the ship to add
	 * @param ship the ship to add
	 * @param c the cord of the top-left corner of the ship
	 * @param ori orientation of the ship
	 * @param player player concerned by the adding
	 * @param dataCells cells' data from JSON save file
	 * @return false if adding the ship fails
	 */
	public boolean addShip(ShipType type, AbstractShip ship, Coord2D c, Orientation ori, PlayerType player, ShipCellData dataCells[]) {
		Grid concernedGrid = null;
	
		if (player == PlayerType.COMPUTER)
			concernedGrid = getComputerGrid();
		else
			concernedGrid = getHumanGrid();
		
		int xCord = c.getX();
		int yCord = c.getY();
		
		if (xCord < 0 || xCord >= 10 || yCord < 0 || yCord >= 10)
			return false;
		
		if (dataCells.length != ship.getSize())
			return false;
		
		if (ori == Orientation.HORIZONTAL)
			if (xCord + ship.getSize() >= 10)
				return false;
		else
			if (yCord + ship.getSize() >= 10)
				return false;
			
		//checking if there is already a ship or not
		for (ShipCellData dataCell : dataCells)
			if (concernedGrid.getCell(dataCell.getX(), dataCell.getY()) instanceof ShipCell)
				return false;
		
		ship.setPosition(c);
		ship.setOrientation(ori);
		setShip(type, ship, player);

		//linking cells on the grid to the ship
		for (ShipCellData dataCell : dataCells)
			concernedGrid.addShipCell(dataCell.getX(), dataCell.getY(), dataCell.getLife(), ship);
		
		return true;
	}
	
	/**
	 * removing a ship
	 * @param type the type of the ship
	 * @param player the player which owns the ship
	 * @return true if deleting succeed
	 */
	public boolean deleteShip(ShipType type, PlayerType player){
		Grid concernedGrid = null;
		
		if (player == PlayerType.COMPUTER)
			concernedGrid = getComputerGrid();
		else
			concernedGrid = getHumanGrid();
		
		AbstractShip ship = getShip(type, player);
		
		for (ShipCell cell : ship.getAsc()){
			int x = cell.getX();
			int y = cell.getY();
			
			concernedGrid.addDefaultSeaCell(x, y);
		}
		
		setShip(type, null, player);
		
		return true;
	}
	
	/**
	 * hit a cell
	 * @param player the player which plays
	 * @param coord the target on the grid
	 * @return false if the target is not valid
	 */
	protected abstract boolean hit(PlayerType player, Coord2D coord);

	public Ships getHumanShips() {
		return humanShips;
	}
}
