package game;

import cell.Grid;
import graphic.Coord2D;
import period.Period;
import player.ComputerPlayer;
import player.PlayerType;
import player.StrategyType;
import ship.AbstractShip;

public class AdvancedGame extends AbstractGame {

	private AbstractShip selectedShipComputer, selectedShipHuman;
	
	public AdvancedGame(Period period, StrategyType strategy) {
		super(period, strategy);
		
		selectedShipComputer = null;
		selectedShipHuman = null;
	}
	
	public GameType getGameType(){
		return GameType.ADVANCED;	
	}

	public void play(Coord2D humanTarget) {
		hit(PlayerType.HUMAN, humanTarget);
		
		ComputerPlayer comp = getComputerPlayer();
		AbstractShip ship = getShip(comp.chooseShip(), PlayerType.COMPUTER);
		setSelectedShip(ship, PlayerType.COMPUTER);
		
		hit(PlayerType.COMPUTER, comp.chooseCell());
	}
	
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
	
	public boolean hit(PlayerType player, Coord2D coord){
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