package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;
//This class is the base weapon. WeaponEffects can wrap it and add effects.
public class Weapon {

protected String damageType;
protected String name;

protected int damageMin;
protected int damageMax;

public Weapon(){
this.damageType = "-";
this.name = "Default";
this.damageMin = 0;
this.damageMax = 0;
}

public Weapon(String name, String dmgType, int min, int max) {
   this.name = name;
   this.damageType = dmgType;
   this.damageMin = min;
   this.damageMax = max;
}

public String description() {
   return this.name;
}

//Returns an attack object with the damage
public Attack attack() {
   Random rand = new Random();
   Damage dmg = new Damage(damageMin + rand.nextInt(damageMax-damageMin), true, damageType);
   Attack atk = new Attack();
   atk.addDamage(dmg);
   return atk;
}

}//end class