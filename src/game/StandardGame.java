package game;

import period.Period;
import player.StrategyType;

public class StandardGame extends AbstractGame {
	
	public StandardGame(Period period, StrategyType strategy){
		super(period, strategy);
	}

	@Override
	public GameType getGameType() {
		return GameType.STANDARD;
	}

}
