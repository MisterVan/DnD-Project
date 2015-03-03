package Project.Damage;

public class ElecResistance {

private int elecReduction;
private double elecMultiplier;

public ElecResistance(int reduction, double multiplier) {
   this.elecReduction = reduction;
   this.elecMultiplier = multiplier;
}

public int processDamage(int dmg) {
   int modifiedDamage = dmg - this.elecReduction;
   modifiedDamage = (int) Math.ceil(modifiedDamage * this.elecMultiplier);
   
   if(modifiedDamage < 0)
      return 0;
   else
      return modifiedDamage;

}

}//end class