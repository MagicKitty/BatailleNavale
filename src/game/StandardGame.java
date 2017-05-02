package game;

import cell.Grid;
import graphic.Coord2D;
import period.Period;
import player.ComputerPlayer;
import player.PlayerType;
import player.StrategyType;

public class StandardGame extends AbstractGame {
	
	public static double DAMAGE = 1.0;
	
	/**
	 * initializing the game with new grids, a specfic factory and a specific strategy for the computer
	 * @param p period selected for the ships' factory
	 * @param strategy computer's strategy selected
	 */
	public StandardGame(Period period, StrategyType strategy){
		super(period, strategy);
	}

	/**
	 * @return the type of the game (Advanced or Standard)
	 */
	@Override
	public GameType getGameType() {
		return GameType.STANDARD;
	}

	/**
	 * playing one turn
	 * @param humanTarget the target choosed by the human player
	 */
	@Override
	public void play(Coord2D humanTarget) {
		hit(PlayerType.HUMAN, humanTarget);
		
		ComputerPlayer comp = getComputerPlayer();
		hit(PlayerType.COMPUTER, comp.chooseCell());
	}

	/**
	 * hit a cell
	 * @param player the player which plays
	 * @param coord the target on the grid
	 * @return false if the target is not valid
	 */
	protected boolean hit(PlayerType player, Coord2D coord){
		Grid concernedGrid = null;
		
		switch (player){
		case COMPUTER:
			concernedGrid = getHumanGrid();
			break;
		case HUMAN:
			concernedGrid = getComputerGrid();
			break;
		}
		
		if (! concernedGrid.isValidHit(coord))
			return false;
		
		concernedGrid.hit(coord, DAMAGE);
		
		return true;
	}
	
}
