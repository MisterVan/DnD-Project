package Project.Status;
import Project.Entity.Entity;
import Project.Damage.Attack;
import Project.Damage.Damage;
import java.util.Random;
//This status effect is poison, which lasts a long time and does a small amount of damage every round.
public class Poison implements StatusEffect {

int counter = 6;
Entity target;


public void applyEffectToTarget(Entity target) {
   this.target = target;
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(10), false, "untyped"));
	target.takeDamage(atk);
	
}

public void reapplyEffectToTarget() {
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(10), false, "untyped"));
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
   return "Poison";
}

public boolean isBeneficial() {
   return false;
}

public void resetDuration() {
   this.counter = 6;
}

}//end class