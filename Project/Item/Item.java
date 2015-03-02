package Project.Item;
import Project.Entity.Entity;


//This acts as parent class for any sort of item the player can have (Weapon/Consumable/Equipment)
public abstract class Item {

protected Entity wielder;
protected String name;

public void pickUp(Entity e) {
   this.wielder = e;
}

public void drop() {
   this.wielder = null;
}

public String getName() {
   return name;
}

}