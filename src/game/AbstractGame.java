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
import player.HumanPlayer;
import player.PlayerType;
import player.RandomStrategy;
import player.StrategyType;
import ship.AbstractShip;
import ship.Orientation;
import ship.ShipType;

public abstract class AbstractGame {
	private Period timePeriod;
	private StrategyType computerStrategy;
	@SuppressWarnings("unused")
	private BattleshipGame bg = null;
	@SuppressWarnings("unused")
	private HumanPlayer humain;
	private ComputerPlayer computer;
	private Grid myGrid;
	private Grid ennemiGrid;
	private IShipFactory sf;
	private ArrayList<AbstractShip> aasHuman = new ArrayList<>(5);
	private ArrayList<AbstractShip> aasComputer = new ArrayList<>(5);
	
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

	public abstract GameType getGameType();
	
	public Period getTimePeriod(){
		return timePeriod;
	}
	
	public StrategyType getComputerStrategy() {
		return computerStrategy;
	}
	
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

	public Grid getMyGrid() {
		return myGrid;
	}

	public Grid getEnnemiGrid() {
		return ennemiGrid;
	}
	
	protected ComputerPlayer getComputerPlayer(){
		return computer;
	}
	
	public abstract void play(Coord2D humanTarget);

	public AbstractShip getShip(ShipType type, PlayerType player) {
		
		ArrayList<AbstractShip> concernedAas = null;
		
		switch(player){
		case COMPUTER:
			concernedAas = aasComputer;
		case HUMAN:
			concernedAas = aasHuman;
		}
		
		switch(type){
		case CARRIER:
			return concernedAas.get(0);
		case BATTLESHIP:
			return concernedAas.get(1);
		case CRUISER:
			return concernedAas.get(2);
		case SUBMARINE:
			return concernedAas.get(3);
		case DESTROYER:
			return concernedAas.get(4);
		default:
			return null;
		}
	}
	
	private void setShip(ShipType type, AbstractShip ship, PlayerType player) {
		
		ArrayList<AbstractShip> concernedAas = null;
		
		switch(player){
		case COMPUTER:
			concernedAas = aasComputer;
		case HUMAN:
			concernedAas = aasHuman;
		}
		
		switch(type){
		case CARRIER:
			concernedAas.set(0, ship);
		case BATTLESHIP:
			concernedAas.set(1, ship);
		case CRUISER:
			concernedAas.set(2, ship);
		case SUBMARINE:
			concernedAas.set(3, ship);
		case DESTROYER:
			concernedAas.set(4, ship);
		}
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
		
		setShip(type, ship, player);
		
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
	
	/**
	 * 
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
			concernedGrid = getEnnemiGrid();
		else
			concernedGrid = getMyGrid();
		
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
		
		setShip(type, ship, player);

		//linking cells on the grid to the ship
		for (ShipCellData dataCell : dataCells)
			concernedGrid.addShipCell(dataCell.getX(), dataCell.getY(), dataCell.getLife(), ship);
		
		return true;
	}
	
	public boolean deleteShip(ShipType type, PlayerType player){
		Grid concernedGrid = null;
		
		if (player == PlayerType.COMPUTER)
			concernedGrid = getEnnemiGrid();
		else
			concernedGrid = getMyGrid();
		
		AbstractShip ship = getShip(type, player);
		
		for (ShipCell cell : ship.getAsc()){
			int x = cell.getX();
			int y = cell.getY();
			
			concernedGrid.addDefaultSeaCell(x, y);
		}
		
		setShip(type, null, player);
		
		return true;
	}
	
	public abstract boolean hit(PlayerType player, Coord2D coord);
}
