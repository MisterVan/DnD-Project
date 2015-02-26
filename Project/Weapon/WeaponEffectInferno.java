package Project.Weapon;

import Project.Damage.Damage;
import Project.Damage.Attack;
import java.util.Random;

//adds Inferno property to a weapon as a suffix effect
//Inferno is a weapon effect that adds additional fire damage to a weapon's attacks
public class WeaponEffectInferno extends WeaponEffect{

public WeaponEffectInferno(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Random rand = new Random();
   Damage dmg = new Damage(10 + rand.nextInt(20), false, "fire");
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return w.description() + " of the Inferno";
}

}//end class