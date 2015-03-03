package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

//adds adamantine weapon property to a weapon as an inherent effect
public class WeaponMetalAdamantine extends WeaponEffect{

public WeaponMetalAdamantine(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Damage initialDamage = atk.getDamage().get(1);
   initialDamage.setDamageType(initialDamage.getDamageType() + ",adamantine");
   return atk;
}

@Override
public String description() {
 return "Adamantine " + w.description();
}

}//end class