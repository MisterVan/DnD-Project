package Project.Damage;

public class FireResistance {

private int fireReduction;
private double fireMultiplier;

public FireResistance(int reduction, double multiplier) {
   this.fireReduction = reduction;
   this.fireMultiplier = multiplier;
}

public int processDamage(int dmg) {
   int modifiedDamage = dmg - this.fireReduction;
   modifiedDamage = (int) Math.ceil(modifiedDamage * this.fireMultiplier);
   
   if(modifiedDamage < 0)
      return 0;
   else
      return modifiedDamage;

}

}//end class