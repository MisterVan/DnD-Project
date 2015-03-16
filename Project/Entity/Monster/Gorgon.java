package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.Poison;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Gorgon extends Monster
{
   
   //Create Gorgon
	public Gorgon()
	{
		setName("Gorgon");
      setHP(130);//185 too high?
	  setPower(30);
      setSpeed(4);
      setAccuracy(0.6);
      setDodge(0.1);
      setDamageReduction(new DamageReduction(5, "slash")); //Vulnerable to slash
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 2.0); //Takes double cold damage
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_GORGON.png");
	}//end method
   
   //Perform attack
	public String performAttack(Entity target)
	{
	if(Math.random() <= this.accuracy)
	{
	  Random rand = new Random();
      Attack atk = new Attack();
      atk.addDamage(new Damage(10+rand.nextInt(5), true, "slash")); //mostly claws/bites
      atk.addDamage(new Damage(10+rand.nextInt(6), false, "acid"));
      atk.applyPower(this.power);
      int poisChance = rand.nextInt(5);
      if(poisChance == 3)//small chance for poison
      {
         Poison poisonEffect = new Poison();
         atk.addStatus(poisonEffect);
      }
      

      return target.takeDamage(atk);
	}
	else
	{
		return ("The attack failed!");

	}
	}//end method
   
   @Override
   public String specialMove(Entity target)
   {
      if(Math.random() <= this.accuracy-0.2)
      {
      Poison poisonEffect = new Poison();
      Attack atk = new Attack();
      Random rand = new Random();
      atk.addDamage(new Damage(40+rand.nextInt(21), true, "slash"));
      atk.addDamage(new Damage(15+rand.nextInt(6), false, "acid"));
      atk.applyPower(this.power/2);
      atk.addStatus(poisonEffect);//definitely poison

      return target.takeDamage(atk);
      }
      else
      {
    	  return ("The attack failed!");

      }
   }
   
}//end Gorgon