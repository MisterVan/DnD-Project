package Project.Item.Consumable;

import Project.Entity.Entity;
import Project.Behavior.Status.Blur;


public class PotionOfBlur extends Consumable {

public PotionOfBlur() {
   super.name = "Potion of Blur";
}

public void pickUp(Entity e) {
   super.wielder = e;
}

public void use() {
   super.wielder.giveStatus(new Blur());
   this.drop();
}

public void drop() {
   super.wielder = null;
}



}