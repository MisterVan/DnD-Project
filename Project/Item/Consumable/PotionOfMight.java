package Project.Item.Consumable;

import Project.Entity.Entity;
import Project.Behavior.Status.Might;


public class PotionOfMight extends Consumable {

public PotionOfMight() {
   super.name = "Potion of Might";
}
public void pickUp(Entity e) {
   super.wielder = e;
}

public void use() {
   super.wielder.giveStatus(new Might());
   this.drop();
}

public void drop() {
   super.wielder = null;
}



}