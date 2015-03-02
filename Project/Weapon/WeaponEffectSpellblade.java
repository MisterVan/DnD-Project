package Project.Weapon;

import Project.Damage.Damage;
import Project.Damage.Attack;
import java.util.Random;

//adds spellblade property to a weapon. This is from the Symbol of the Spellsword.
//It does not modify the name of the weapon, but wraps it in order to add damage
public class WeaponEffectSpellblade extends WeaponEffect{

public WeaponEffectSpellblade(Weapon w) {
   super.w = w;
}

@Override
public Attack attack(){
   Random rand = new Random();
   Damage dmg = new Damage(8 + rand.nextInt(8), false, "untyped");
   Attack atk = w.attack();
   atk.addDamage(dmg);
   return atk;
}

@Override
public String description() {
 return w.description();
}

}//end class