package Project.Gryphon;

import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;

public class Gryphon extends Entity
{
   
   //Create Gryphon
	public Gryphon()
	{
		setName("Gryphon");
      setHP(159);
		setPower(30);
      setSpeed(40);
      setAccuracy(0.7);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(15, "slash")); //Vulnerable to slash
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 2.0); //Takes double cold damage
      elRes.setElec(0, 1.5); //Takes one and a half electric damage
      
      setElementalResistance(elRes);
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, true, "slash")); //mostly claws/bites
      atk.addDamage(new Damage(20, true, "bludgeon"));
      return atk;
	}//end method
   
   private void hurtSpeed()
   {
      //For every 10 units of slash damage taken, speed is reduced by 0.1
   }
   
}//end Gryphon