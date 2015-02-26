package Project.Weapon;

import Project.Damage.Damage;
import Project.Damage.Attack;
import java.util.Random;

//adds silver weapon property to a weapon as an inherent effect
public class WeaponMetalSilver extends WeaponEffect{

public WeaponMetalSilver(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Attack atk = w.attack();
   Damage initialDamage = atk.getDamage().get(1);
   initialDamage.setDamageType(initialDamage.getDamageType() + ",silver");
   return atk;
}

@Override
public String description() {
 return "Silver " + w.description();
}

}//end class