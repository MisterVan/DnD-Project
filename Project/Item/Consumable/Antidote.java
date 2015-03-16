package Project.Item.Consumable;

import Project.Entity.Entity;
import Project.Behavior.Status.StatusEffect;
import java.util.ArrayList;

//This potion cures all bad status effects on the user.
public class Antidote extends Consumable {

public Antidote() {
   super.name = "Antidote";
   super.setSprite("Project/Sprites/Item/Potion/ITEM_POTION_ANTIDOTE.png");
}

public void pickUp(Entity e) {
   super.wielder = e;
}


public void use() {
   ArrayList<StatusEffect> list = super.wielder.getStatusEffects();
   
   for(int i = 0; i < list.size(); i++) {
      StatusEffect s = list.get(i);
      if(!s.isBeneficial()) // if it's bad
      {
      list.remove(s);
      }
      
   }//end loop
   this.drop();
}

public void drop() {
   super.wielder = null;
}

}