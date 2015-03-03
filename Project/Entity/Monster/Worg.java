package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Worg extends Entity
{
   
   //Create Worg
	public Worg()
	{
		setName("Worg");
      setHP(130);
		setPower(30);
      setSpeed(50);
      setAccuracy(0.8);
      setDodge(0.5);
      setDamageReduction(new DamageReduction(10, "fire")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setFire(0, 1.1); //Takes one and one-tenth fire damage due to fur
      
      setElementalResistance(elRes);
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(40, true, "slash")); //only able to claw/bite
      return atk;
	}//end method
   
   private void tripTarget()
   {
      //Has a random chance of tripping a target during an attack
   }
   
}//end Worg