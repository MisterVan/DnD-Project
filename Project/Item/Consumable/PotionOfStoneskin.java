package Project.Item.Consumable;

import Project.Entity.Entity;
import Project.Behavior.Status.Stoneskin;


public class PotionOfStoneskin extends Consumable {

public PotionOfStoneskin() {
   super.name = "Potion of Stoneskin";
}
public void pickUp(Entity e) {
   super.wielder = e;
}

public void use() {
   super.wielder.giveStatus(new Stoneskin());
   this.drop();
}

public void drop() {
   super.wielder = null;
}



}