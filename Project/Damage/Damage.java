package Project.Damage;


/*
This class is used any time damage is being dealt to an etity. 
It acts as a package for the amount of damage and the type of damage
that is being dealth for the purpose of calculating defenses.
*/
public class Damage {

private int dmg;
private boolean isPhysical;
private String dmgType; //The type(s) of damage that this object is dealing. This contains both the weapon's damage type AND its metal composition if it is physical.
                //NOTE: for multiple damage types, use comma as a delimiter. Therefore, a silver morningstar would have 'bludgeon,pierce,silver' in its composition
                //Proper notation for each damage type: slash, bludgeon, pierce, steel, adamantine, silver, metalline, acid, fire, cold, electric, untyped

public Damage(int dmgAmount, boolean isPhysical, String dmgType) {
   this.dmg = dmgAmount;
   this.isPhysical = isPhysical;
   this.dmgType = dmgType;
}//end constructor

public void setDamageType(String type) {
   this.dmgType = (type);
}

public String getDamageType() {
   return this.dmgType;
}

public int getDamage() {
   return this.dmg;
}

public boolean isPhysical() {
   return this.isPhysical;
}

//When an attack is a critical, it gets multiplied by calling this method.
public void multiply(int factor) {
   this.dmg = this.dmg * factor;
}

}//end class