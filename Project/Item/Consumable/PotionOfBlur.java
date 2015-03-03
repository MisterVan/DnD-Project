package Project.Item.Consumable;

import Project.Entity.Entity;
import Project.Behavior.Status.Blur;


public class PotionOfBlur extends Consumable {


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