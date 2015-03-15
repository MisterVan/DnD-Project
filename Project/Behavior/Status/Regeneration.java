package Project.Behavior.Status;

import Project.Entity.Entity;
import java.util.Random;

public class Regeneration implements StatusEffect {

	int counter = 5;
	Entity wielder;
	@Override
	public void applyEffectToTarget(Entity target) {
		Random rand = new Random();
		this.wielder = target;
		int amount = 10 + rand.nextInt(15);
		wielder.recoverHP(amount);
	}

	@Override
	public void reapplyEffectToTarget() {
		this.counter--;
		Random rand = new Random();
		int amount = 10 +rand.nextInt(15);
		wielder.recoverHP(amount);
	}

	@Override
	public void removeEffectFromTarget() {
		this.wielder = null;

	}

	@Override
	public void resetDuration() {
		this.counter = 5;
	}

	@Override
	public boolean isBeneficial() {
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Regeneration";
	}

	@Override
	public int getCounter() {
		return counter;
	}

}
