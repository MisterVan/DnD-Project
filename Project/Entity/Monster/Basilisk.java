package Project.Basilisk;

import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;

public class Basilisk extends Entity
{
   
   //Create Basilisk
	public Basilisk()
	{
		setName("Basilisk");
      setHP(145);
		setPower(30);
      setSpeed(20);
      setAccuracy(0.7);
      setDodge(0.4);
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
      atk.addDamage(new Damage(20, true, "slash"));
      atk.addDamage(new Damage(5, true, "bludgeon"));
      atk.addDamage(new Damage(20, false, "acid")); //chance for poison
      return atk;
	}//end method
   
   private void paralyzeTarget()
   {
      //Has a random chance of catching a player's gaze and paralyzing them each round
   }
   
}//end Basilisk