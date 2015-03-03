package Project.Gorgon;

import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;

public class Gorgon extends Entity
{
   
   //Create Gorgon
	public Gorgon()
	{
		setName("Gorgon");
      setHP(149);//185 too high?
		setPower(30);
      setSpeed(30);
      setAccuracy(0.6);
      setDodge(0.3);
      setDamageReduction(new DamageReduction(10, "cold")); //Vulnerable to cold
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 2.0); //Takes double cold damage
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "slash")); //mostly claws/bites
      atk.addDamage(new Damage(15, true, "bludgeon"));
      atk.addDamage(new Damage(15, false, "acid")); //able to poison targets
      return atk;
	}//end method
   
   private void paralyzeTarget()
   {
      //Has a random chance of catching a player's gaze and paralyzing them each round
   }
   
}//end Gorgon