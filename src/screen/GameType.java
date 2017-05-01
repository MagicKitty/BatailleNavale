package screen;

import period.Period;
import player.StrategyType;

public class GameType {
	private Period _period;
	private StrategyType _algorithm;
	private String _shot;
	
	public GameType() {
	}

	public StrategyType getAlgorithm() {
		return _algorithm;
	}

	public void setAlgorithm(StrategyType algorithm) {
		_algorithm = algorithm;
	}

	public Period getPeriod() {
		return _period;
	}

	public void setPeriod(Period period) {
		_period = period;
	}

	public String getShot() {
		return _shot;
	}

	public void setShot(String shot) {
		_shot = shot;
	}
	
	public String toString() {
		return "[period=" + _period + ", shot=" + _shot + ", algorithm=" + _algorithm + "]";
	}
}