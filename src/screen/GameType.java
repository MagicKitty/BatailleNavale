package screen;

public class GameType {
	private String _period, _shot, _algorithm;
	
	public GameType() {
	}

	public String getAlgorithm() {
		return _algorithm;
	}

	public void setAlgorithm(String algorithm) {
		_algorithm = algorithm;
	}

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
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