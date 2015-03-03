package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds a untyped property to a weapon as a prefix effect that deals additional untyped damage
public class WeaponEffectDestructive extends WeaponEffect{

public WeaponEffectDestructive(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(4 + rand.nextInt(4), false, "untyped");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return "Destructive " + w.description();
}

}//end class