package Project.Weapon;

import Project.Damage.Damage;
import Project.Damage.Attack;
import java.util.Random;

//adds Black Dragon property to a weapon as a suffix effect
//Black Dragon is a weapon effect that adds additional acid damage to a weapon's attacks
public class WeaponEffectBlackDragon extends WeaponEffect{

public WeaponEffectBlackDragon(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Random rand = new Random();
   Damage dmg = new Damage(10 + rand.nextInt(20), false, "acid");
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return w.description() + " of the Black Dragon";
}

}//end class