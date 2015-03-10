package Project.Item.Consumable;

import Project.Entity.Entity;


public class ElixirOfLife extends Consumable {

public ElixirOfLife() {
   super.name = "Elixir of Life";
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