package Project.Item.Consumable;

import Project.Entity.Entity;


public class ElixirOfLife extends Consumable {


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