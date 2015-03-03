package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds Blizzard property to a weapon as a suffix effect
//Blizzard is a weapon effect that adds additional cold damage to a weapon's attacks
public class WeaponEffectBlizzard extends WeaponEffect{

public WeaponEffectBlizzard(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Random rand = new Random();
   Damage dmg = new Damage(10 + rand.nextInt(20), false, "cold");
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return w.description() + " of the Blizzard";
}

}//end class