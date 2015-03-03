package Project.Weapon;

import Project.Damage.Damage;
import Project.Damage.Attack;
import java.util.Random;

//adds puncturing property to a weapon as a prefix effect that adds piercing damage
public class WeaponEffectPuncturing extends WeaponEffect{

public WeaponEffectPuncturing(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(5 + rand.nextInt(5), true, "pierce");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return "Puncturing " + w.description();
}

}//end class