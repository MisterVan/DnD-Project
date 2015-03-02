package Project.Item.Equipment;

import Project.Entity.Entity;

public class RingOfRegeneration extends Equipment {


public RingOfRegeneration() {
   super.name = "Ring of Regeneration";
}
public void pickUp(Entity e) {
 super.wielder = e;
}



@Override
public void procEffect() {
   super.wielder.recoverHP(25); //recover 25 hp a round
}

public void drop() {
   super.wielder = null;
}

}