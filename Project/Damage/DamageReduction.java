package Project.Damage;

public class DamageReduction {

private int reduction; //The amount by which damage is reduced
private String bypass; //The things that bypass this damage reduction

public DamageReduction(int amount, String bypassedBy) {
   this.reduction = amount;
   this.bypass = bypassedBy;
}//end constructor

public int processDamage(Damage dmg) {
   String[] typeList = dmg.getDamageType().split(",");
   for(String type : typeList) {
      if(this.bypass.toLowerCase().contains(type.toLowerCase())) //if true, it bypasses the damage reduction
         return dmg.getDamage();
      }
   //If we got here, the damage isn't bypassing the damage reduction
   int modifiedDamage = dmg.getDamage() - this.reduction;
   if(modifiedDamage < 0) //Don't want to return a negative number
      return 0;
   else
      return modifiedDamage;
}

}//end class