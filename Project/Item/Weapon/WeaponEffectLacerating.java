package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds lacerating property to a weapon as a prefix effect that adds slashing damage
public class WeaponEffectLacerating extends WeaponEffect{

public WeaponEffectLacerating(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(5 + rand.nextInt(5), true, "slash");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return "Lacerating " + w.description();
}

}//end class