package Project.Item.Consumable;

import Project.Entity.Entity;


public class ElixirOfLife extends Consumable {

public ElixirOfLife() {
   super.name = "Elixir of Life";
   super.setSprite("Project/Sprites/Item/Potion/ITEM_POTION_HEALING.png");
}
public void pickUp(Entity e) {
   super.wielder = e;
}

public void use() {
   super.wielder.recoverHP(9999);
   this.drop();
}

public void drop() {
   super.wielder = null;
}

}