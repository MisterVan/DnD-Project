package Project.Weapon;

import Project.Damage.Damage;
import Project.Damage.Attack;
import java.util.Random;

//adds Storm property to a weapon as a suffix effect
//Storm is a weapon effect that adds additional electric damage to a weapon's attacks
public class WeaponEffectStorm extends WeaponEffect{

public WeaponEffectStorm(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Random rand = new Random();
   Damage dmg = new Damage(10 + rand.nextInt(20), false, "electric");
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return w.description() + " of the Storm";
}

}//end class