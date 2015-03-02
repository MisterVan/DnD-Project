package Project.Item.Equipment;

import Project.Entity.Entity;

public class BerserkerBand extends Equipment {

int addedPower;
double lostAccuracy;

public BerserkerBand() {
   super.name = "Berserker's Band";
}

//When affecting stats, we want to avoid multiplicative affects
public void pickUp(Entity e) {
   super.wielder = e;
   addedPower = (super.wielder.getPower()*3) - super.wielder.getPower();
   lostAccuracy = super.wielder.getAccuracy() - (super.wielder.getAccuracy()/2);
   super.wielder.setPower(super.wielder.getPower() + addedPower); //Triples power
   super.wielder.setAccuracy(super.wielder.getAccuracy() - lostAccuracy); //But halves accuracy
}

public void drop() {
   super.wielder.setPower(super.wielder.getPower() - addedPower); //take power away
   super.wielder.setAccuracy(super.wielder.getAccuracy() + lostAccuracy); //restore accuracy
   super.wielder = null;
}



}//end class