package player;

import game.AbstractGame;
import graphic.Coord2D;
import ship.ShipType;

public class ComputerPlayer {
	IChooseCellStrategy ccs;
	AbstractGame game;

	public ComputerPlayer(AbstractGame game){
		this.game = game;
	}
	
	public ShipType chooseShip() {
		return ccs.chooseShip(game.getComputerShips());
	}

	public Coord2D chooseCell() {
		return ccs.chooseCell(game.getHumanGrid());
	}
	
	public void setStrategy(IChooseCellStrategy ccs) {
		this.ccs = ccs;
	}

}
