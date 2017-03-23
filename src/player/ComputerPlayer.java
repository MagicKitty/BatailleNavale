package player;

import graphic.Coord2D;

public class ComputerPlayer implements IPlayer {
	IChooseCellStrategy ccs;

	@Override
	public String chooseShip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coord2D chooseCell() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setStrategy(IChooseCellStrategy ccs) {
		this.ccs = ccs;
	}

}
