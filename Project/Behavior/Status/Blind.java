package Project.Status;
import Project.Entity.Entity;

//This status effect is blindness, which severely hinders an entity's ability to hit things or dodge incoming attacks.
public class Blind implements StatusEffect {

int counter = 3;
Entity target;


public void applyEffectToTarget(Entity target) {
   this.target = target;
   this.target.setAccuracy(this.target.getAccuracy() / 2);
	this.target.setDodge(this.target.getDodge() / 2);
}

public void reapplyEffectToTarget() {
this.counter--;
}

public void removeEffectFromTarget() {
   this.target.setAccuracy(this.target.getAccuracy() * 2);
	this.target.setDodge(this.target.getDodge() * 2);
   this.target = null;
}

public int getCounter() {
   return this.counter;
}

public String getName() {
   return "Blind";
}

public boolean isBeneficial() {
   return false;
}

public void resetDuration() {
   this.counter = 3;
}

}//end class