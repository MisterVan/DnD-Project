package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds flaming property to a weapon as a prefix effect
public class WeaponEffectFlaming extends WeaponEffect{

public WeaponEffectFlaming(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(2 + rand.nextInt(6), false, "fire");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return "Flaming " + w.description();
}

}//end class