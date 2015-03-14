package Project.Behavior.Status;
import Project.Entity.Entity;
//import Project.Behavior.Defense.DamageReduction;

public class Stoneskin implements StatusEffect {

int counter = 3;
Entity target;


public void applyEffectToTarget(Entity target) {
   this.target = target;
   this.target.getDamageReduction().setReduction(this.target.getDamageReduction().getReduction() + 20);
}

public void reapplyEffectToTarget() {
this.counter--;
}

public void removeEffectFromTarget() {
   this.target.getDamageReduction().setReduction(this.target.getDamageReduction().getReduction() - 20);
   this.target = null;
}

public int getCounter() {
   return this.counter;
}

public String getName() {
   return "Stoneskin";
}

public boolean isBeneficial() {
   return true;
}

public void resetDuration() {
   this.counter = 3;
}

}//end class