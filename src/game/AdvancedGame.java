package game;

import cell.Grid;
import graphic.Coord2D;
import period.Period;
import player.ComputerPlayer;
import player.PlayerType;
import player.StrategyType;
import ship.AbstractShip;
import ship.ShipType;
import ship.Ships;

public class AdvancedGame extends AbstractGame {

	private AbstractShip selectedShipComputer, selectedShipHuman;
	
	/**
	 * initializing the game with new grids, a specfic factory and a specific strategy for the computer
	 * @param p period selected for the ships' factory
	 * @param strategy computer's strategy selected
	 */
	public AdvancedGame(Period period, StrategyType strategy) {
		super(period, strategy);
		
		selectedShipComputer = null;
		selectedShipHuman = null;
	}
	
	/**
	 * @return the type of the game (Advanced or Standard)
	 */
	public GameType getGameType(){
		return GameType.ADVANCED;	
	}

	/**
	 * playing one turn
	 * @param humanTarget the target choosed by the human player
	 */
	public void play(Coord2D humanTarget) {
		hit(PlayerType.HUMAN, humanTarget);
		
		ComputerPlayer comp = getComputerPlayer();
		AbstractShip ship = getShip(comp.chooseShip(), PlayerType.COMPUTER);
		setSelectedShip(ship, PlayerType.COMPUTER);
		
		hit(PlayerType.COMPUTER, comp.chooseCell());
	}
	
	/**
	 * setting which ship is selected
	 * @param ship ship concerned
	 * @param player player concerned
	 */
	public void setSelectedShip(AbstractShip ship, PlayerType player){
		switch (player){
		case COMPUTER:
			selectedShipComputer = ship;
			break;
		case HUMAN:
			selectedShipHuman = ship;
			break;
		}
	}
	
	public void setSelectedShip(ShipType type, PlayerType player){
		Ships concernedShips = null;
		
		switch (player){
		case COMPUTER:
			concernedShips = getComputerShips();
			break;
		case HUMAN:
			concernedShips = getHumanShips();
			break;
		}
		
		AbstractShip ship = concernedShips.getShip(type);
		
		this.setSelectedShip(ship, player);
	}
	
	/**
	 * getting the ship which was selected for playing
	 * @param player the player which plays
	 * @return player's selected ship
	 */
	public AbstractShip getSelectedShip(PlayerType player){
		switch (player){
		case COMPUTER:
			return selectedShipComputer;
		case HUMAN:
			return selectedShipHuman;
		default:
			return null;
		}
	}
	
	/**
	 * hit a cell
	 * @param player the player which plays
	 * @param coord the target on the grid
	 * @return false if the target is not valid
	 */
	protected boolean hit(PlayerType player, Coord2D coord){
		Grid concernedGrid = null;
		AbstractShip concernedShip = null;
		
		switch (player){
		case COMPUTER:
			concernedGrid = getHumanGrid();
			concernedShip = selectedShipComputer;
			break;
		case HUMAN:
			concernedGrid = getComputerGrid();
			concernedShip = selectedShipHuman;
			break;
		}
		
		if (! concernedGrid.isValidHit(coord))
			return false;
		
		if (concernedShip == null)
			return false;
		
		double damage = concernedShip.getAttack();
		
		concernedGrid.hit(coord, damage);
		
		return true;
	}
}