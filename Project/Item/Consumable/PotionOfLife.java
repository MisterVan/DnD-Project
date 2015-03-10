package Project.Item.Consumable;

import Project.Entity.Entity;


public class PotionOfLife extends Consumable {

public PotionOfLife() {
   super.name = "Potion of Life";
}
public void pickUp(Entity e) {
   super.wielder = e;
}

public void use() {
   super.wielder.recoverHP(50);
   this.drop();
}

public void drop() {
   super.wielder = null;
}

}