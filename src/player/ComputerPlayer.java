package player;

import java.util.Random;

import game.AbstractGame;
import graphic.Coord2D;
import ship.Orientation;
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
	
	public void placeShips(){
		Random r = new Random();
		
		for (ShipType type : ShipType.values()){
			System.out.println(type);
			
			Coord2D c = new Coord2D(r.nextInt(10), r.nextInt(10));
			Orientation ori = Orientation.values()[r.nextInt(Orientation.values().length)];
			
			while (!(game.addShipDefault(type, c, ori, PlayerType.COMPUTER))){
				c = new Coord2D(r.nextInt(10), r.nextInt(10));
				ori = Orientation.values()[r.nextInt(Orientation.values().length)];
			}
		}
	}

}
