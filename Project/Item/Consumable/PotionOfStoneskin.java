package Project.Item.Consumable;

import Project.Entity.Entity;
import Project.Status.Stoneskin;


public class PotionOfStoneskin extends Consumable {


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