package Project.Entity.Monster;

import Project.Entity.Entity;

import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Zombie extends Entity
{
   
   //Create Basilisk
	public Zombie()
	{
		setName("Zombie");
      setHP(116);
		setPower(30);
      setSpeed(10);
      setAccuracy(0.5);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(8, "slash")); //Vulnerable to slash
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "bludgeon"));
      atk.addDamage(new Damage(5, true, "slash"));
      return atk;
	}//end method
   
   //Zombie has no special qualities
   
}//end Zombie