package Project.Behavior.Status;
import Project.Entity.Entity;

//Blur as an effect that makes the entity's true location hard to see, making it a harder target to hit.
public class Blur implements StatusEffect {

int counter = 3; //This determines how long the buff lasts, and decrements on each call of reapply(). 
Entity target;

public void applyEffectToTarget(Entity target) {
   this.target = target;
   this.target.setDodge(this.target.getDodge() + 0.20); //Adds 20% to the entity's dodge ability
}

public void reapplyEffectToTarget() {
   this.counter--; //Counts down, doesn't do anything else since its effect is still active.
}

public void removeEffectFromTarget() {
   this.target.setDodge(this.target.getDodge() - 0.20); //Remove the bonus the buff applied
   this.target = null;
}

public boolean isBeneficial() {
   return true;
}

public void resetDuration() {
   this.counter = 3;
}

public String getName() {
   return "Blur";
}

public int getCounter() {
   return this.counter;
}

}//end class