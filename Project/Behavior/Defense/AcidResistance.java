package Project.Behavior.Defense;

public class AcidResistance {

private int acidReduction;
private double acidMultiplier;

public AcidResistance(int reduction, double multiplier) {
   this.acidReduction = reduction;
   this.acidMultiplier = multiplier;
}

public int processDamage(int dmg) {
   int modifiedDamage = dmg - this.acidReduction;
   modifiedDamage = (int) Math.ceil(modifiedDamage * this.acidMultiplier);
   
   if(modifiedDamage < 0)
      return 0;
   else
      return modifiedDamage;

}

}//end class