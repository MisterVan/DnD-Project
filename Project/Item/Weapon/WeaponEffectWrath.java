package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds Wrath property to a weapon as a suffix effect
//Wrath is a weapon effect that gives a small chance to deal massive(typically lethal) damage
public class WeaponEffectWrath extends WeaponEffect{

public WeaponEffectWrath(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Random rand = new Random();
   if(rand.nextDouble() < 0.05) {//5% chance
   Damage dmg = new Damage(1000, false, "untyped"); 
   atk.addDamage(dmg);
   }//end if
   return atk;
}

@Override
public String description() {
 return w.description() + " of Wrath";
}

}//end class