package Project.Item.Consumable;

import Project.Entity.Entity;
import Project.Behavior.Status.Stoneskin;


public class PotionOfStoneskin extends Consumable {

public PotionOfStoneskin() {
   super.name = "Potion of Stoneskin";
   super.setSprite("Project/Sprites/Item/Potion/ITEM_POTION_POTIONOFSTONESKIN.png");
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