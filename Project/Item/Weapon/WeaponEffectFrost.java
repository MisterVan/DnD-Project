package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds frost property to a weapon as a prefix effect
public class WeaponEffectFrost extends WeaponEffect{

public WeaponEffectFrost(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(2 + rand.nextInt(6), false, "cold");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return "Frost " + w.description();
}

}//end class