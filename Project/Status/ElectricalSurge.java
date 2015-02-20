package Project.Status;
import Project.Entity.Entity;
import Project.Damage.Attack;
import Project.Damage.Damage;
import java.util.Random;
//This status effect is a damage over time effect for electricity.
public class ElectricalSurge implements StatusEffect {

int counter = 3;
Entity target;


public void applyEffectToTarget(Entity target) {
   this.target = target;
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(25), false, "electric"));
	target.takeDamage(atk);
	
}

public void reapplyEffectToTarget() {
	Random rand = new Random();
	Attack atk = new Attack();
	atk.addDamage(new Damage(rand.nextInt(25), false, "electric"));
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
   return "Electrical Surge";
}

public boolean isBeneficial() {
   return false;
}

public void resetDuration() {
   this.counter = 3;
}

}//end class