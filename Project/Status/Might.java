package Project.Status;
import Project.Entity.Entity;

public class Might implements StatusEffect {

int counter = 3; //This determines how long the buff lasts, and decrements on each call of reapply(). 
Entity target;

public void applyEffectToTarget(Entity target) {
   this.target = target;
   this.target.setPower(this.target.getPower() + 50); //Adds 20% to the entity's dodge ability
}

public void reapplyEffectToTarget() {
   this.counter--; //Counts down, doesn't do anything else since its effect is still active.
}

public void removeEffectFromTarget() {
   this.target.setPower(this.target.getPower() - 50); //Remove the bonus the buff applied
   this.target = null;
}

public boolean isBeneficial() {
   return true;
}

public void resetDuration() {
   this.counter = 3;
}

public String getName() {
   return "Might";
}

public int getCounter() {
   return this.counter;
}

}//end class