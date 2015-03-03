package Project.Behavior.Defense;

public class ColdResistance {

private int coldReduction;
private double coldMultiplier;

public ColdResistance(int reduction, double multiplier) {
   this.coldReduction = reduction;
   this.coldMultiplier = multiplier;
}

public int processDamage(int dmg) {
   int modifiedDamage = dmg - this.coldReduction;
   modifiedDamage = (int) Math.ceil(modifiedDamage * this.coldMultiplier);
   
   if(modifiedDamage < 0)
      return 0;
   else
      return modifiedDamage;

}

}//end class