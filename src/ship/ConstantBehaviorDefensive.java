package ship;

public class ConstantBehaviorDefensive implements IBehaviorDefensive {
	private double defense;
	
	public ConstantBehaviorDefensive(double defense) {
		this.defense = defense;
	}
	
	@Override
	public double getDefense() {
		return defense;
	}

}
