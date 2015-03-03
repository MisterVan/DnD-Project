package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds corrosive property to a weapon as a prefix effect
public class WeaponEffectCorrosive extends WeaponEffect{

public WeaponEffectCorrosive(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(2 + rand.nextInt(6), false, "acid");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return "Corrosive " + w.description();
}

}//end class