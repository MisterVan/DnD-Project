package Project.Status;
import Project.Entity.Entity;
import Project.Damage.Attack;
import Project.Damage.Damage;
import java.util.Random;
//This status effect is a damage over time effect for cold.
public class Frostbite implements StatusEffect {

int counter = 3;
Entity target;


public void applyEffectToTarget(Entity target) {
   this.target = target;
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(20), false, "cold"));
	target.takeDamage(atk);
	
}

public void reapplyEffectToTarget() {
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(20), false, "cold"));
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
   return "Frostbite";
}

public boolean isBeneficial() {
   return false;
}

public void resetDuration() {
   this.counter = 3;
}

}//end class