package Project.Behavior.Status;

import Project.Entity.Entity;
import Project.Behavior.Offense.Attack;
import Project.Behavior.Offense.Damage;
import java.util.Random;
//This status effect is a damage over time effect for fire.
public class BurningFlames implements StatusEffect {

int counter = 3;
Entity target;


public void applyEffectToTarget(Entity target) {
   this.target = target;
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(25), false, "fire"));
	target.takeDamage(atk);
	
}

public void reapplyEffectToTarget() {
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(25), false, "fire"));
	target.takeDamage(atk);
		
	this.counter--;
}

public void removeEffectFromTarget() {
   this.target = null;
}

public int getCounter() {
   return this.counter;
}

public String getName() {
   return "Burning Flames";
}

public boolean isBeneficial() {
   return false;
}

public void resetDuration() {
   this.counter = 3;
}

}//end class