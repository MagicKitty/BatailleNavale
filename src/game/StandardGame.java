package game;

import cell.Grid;
import graphic.Coord2D;
import period.Period;
import player.ComputerPlayer;
import player.PlayerType;
import player.StrategyType;

public class StandardGame extends AbstractGame {
	
	public static double DAMAGE = 1.0;
	
	public StandardGame(Period period, StrategyType strategy){
		super(period, strategy);
	}

	@Override
	public GameType getGameType() {
		return GameType.STANDARD;
	}

	@Override
	public void play(Coord2D humanTarget) {
		hit(PlayerType.HUMAN, humanTarget);
		
		ComputerPlayer comp = getComputerPlayer();
		hit(PlayerType.COMPUTER, comp.chooseCell());
	}

	public boolean hit(PlayerType player, Coord2D coord){
		Grid concernedGrid = null;
		
		switch (player){
		case COMPUTER:
			concernedGrid = getMyGrid();
			break;
		case HUMAN:
			concernedGrid = getEnnemiGrid();
			break;
		}
		
		if (! concernedGrid.isValidHit(coord))
			return false;
		
		concernedGrid.hit(coord, DAMAGE);
		
		return true;
	}
	
}
