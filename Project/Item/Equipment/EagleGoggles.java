package Project.Item.Equipment;

import Project.Entity.Entity;

public class EagleGoggles extends Equipment {

public EagleGoggles() {
   super.name = "Goggles of Eagle's Eye";
}

public void pickUp(Entity e) {
   super.wielder = e;
   super.wielder.setAccuracy(e.getAccuracy()+0.3); //adds 30% accuracy
}

public void drop() {
   super.wielder.setAccuracy(super.wielder.getAccuracy()-0.3); //remove accuracy
   super.wielder = null;  
}



}//end class