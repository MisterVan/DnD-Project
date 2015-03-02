package Project.Item.Consumable;

import Project.Entity.Entity;


public class GreaterPotionOfLife extends Consumable {


public void pickUp(Entity e) {
   super.wielder = e;
}

public void use() {
   super.wielder.recoverHP(100);
   this.drop();
}

public void drop() {
   super.wielder = null;
}

}