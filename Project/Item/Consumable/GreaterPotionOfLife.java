package Project.Item.Consumable;

import Project.Entity.Entity;


public class GreaterPotionOfLife extends Consumable {

public GreaterPotionOfLife() {
   super.name = "Greater Potion of Life";
   super.setSprite("Project/Sprites/Item/Potion/ITEM_POTION_HEALING.png");
}

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