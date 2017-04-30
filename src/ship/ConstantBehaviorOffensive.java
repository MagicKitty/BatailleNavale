package ship;

public class ConstantBehaviorOffensive implements IBehaviorOffensive {
	private double attack;
	
	public ConstantBehaviorOffensive(double attack) {
		this.attack = attack;
	}
	
	@Override
	public double getAttack() {
		return attack;
	}
}
