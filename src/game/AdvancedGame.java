package game;

import period.Period;
import player.StrategyType;

public class AdvancedGame extends StandardGame {

	public AdvancedGame(Period period, StrategyType strategy) {
		super(period, strategy);
		// TODO Auto-generated constructor stub
	}
	
	public GameType getGameType(){
		return GameType.ADVANCED;	
	}

}