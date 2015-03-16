package Project.Item.Equipment;

import Project.Entity.Entity;

public class WraithCloak extends Equipment {

public WraithCloak() {
   super.name = "Cloak of the Wraith";
   super.setSprite("Project/Sprites/Item/Equipment/ITEM_EQUIPMENT_WRAITHCLOAK.png");
}

public void pickUp(Entity e) {
   super.wielder = e;
   super.wielder.setDodge(e.getDodge()+0.2); //adds 20% dodge
}

public void drop() {
   super.wielder.setDodge(super.wielder.getDodge()-0.2); //remove dodge bonus
   super.wielder = null;  
}



}//end class