package Project.Behavior.Defense;

import Project.Behavior.Offense.Damage;

public class ElementalResistance {

private ColdResistance cold;
private FireResistance fire;
private AcidResistance acid;
private ElecResistance elec;

public ElementalResistance() {
   cold = new ColdResistance(0, 1.0);
   fire = new FireResistance(0, 1.0);
   acid = new AcidResistance(0, 1.0);
   elec = new ElecResistance(0, 1.0);
}

public int processDamage(Damage dmg) {
   if(dmg.getDamageType().toLowerCase().equals("cold"))
      return cold.processDamage(dmg.getDamage());
   else if(dmg.getDamageType().toLowerCase().equals("fire"))
      return fire.processDamage(dmg.getDamage());
   else if(dmg.getDamageType().toLowerCase().equals("acid"))
      return acid.processDamage(dmg.getDamage());
   else if(dmg.getDamageType().toLowerCase().equals("electric"))
      return elec.processDamage(dmg.getDamage());
   else if(dmg.getDamageType().toLowerCase().equals("untyped"))
      return dmg.getDamage();
      
   return dmg.getDamage();
}

public void setCold(int i, double d) {
   this.cold = new ColdResistance(i, d);
}

public void setFire(int i , double d) {
   this.fire = new FireResistance(i, d);
}

public void setAcid(int i, double d) {
   this.acid = new AcidResistance(i, d);
}

public void setElec(int i, double d) {
   this.elec = new ElecResistance(i, d);
}

}//end class