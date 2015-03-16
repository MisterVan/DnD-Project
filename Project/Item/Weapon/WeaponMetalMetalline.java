package Project.Item.Weapon;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

//adds metalline weapon property to a weapon as an inherent effect
public class WeaponMetalMetalline extends WeaponEffect{

public WeaponMetalMetalline(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Damage initialDamage = atk.getDamage().get(0);
   initialDamage.setDamageType(initialDamage.getDamageType() + ",adamantine,silver");
   return atk;
}

@Override
public String description() {
 return "Metalline " + w.description();
}

}//end class