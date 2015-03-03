package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds shattering property to a weapon as a prefix effect that adds bludgeon damage
public class WeaponEffectShattering extends WeaponEffect{

public WeaponEffectShattering(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(5 + rand.nextInt(5), true, "bludgeon");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return "Shattering " + w.description();
}

}//end class