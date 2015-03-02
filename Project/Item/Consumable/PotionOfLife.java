package Project.Item.Consumable;

import Project.Entity.Entity;


public class PotionOfLife extends Consumable {


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