package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.Poison;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Basilisk extends Monster
{
   
   //Create Basilisk
	public Basilisk()
	{
		setName("Basilisk");
      setHP(145);
      setPower(30);
      setSpeed(4);
      setAccuracy(0.6);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(10, "cold")); //Vulnerable to cold
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(0, 2.0); //Takes double cold damage    
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_BASILISK.png");
	}//end method
   
   //Perform attack
	@Override
	public String performAttack(Entity target)
	{
		if(Math.random() <= this.accuracy)
		{
		  Random rand = new Random();
	      Attack atk = new Attack();
	      atk.addDamage(new Damage(10+rand.nextInt(5), true, "slash"));
	      atk.addDamage(new Damage(3+rand.nextInt(5), true, "bludgeon"));
	      atk.addDamage(new Damage(15+rand.nextInt(5), false, "acid"));
	      atk.applyPower(super.power);
	
	      int poisChance = rand.nextInt(5);
	      if(poisChance == 3)//small chance for poison
	      {
	         Poison poisonEffect = new Poison();
	         atk.addStatus(poisonEffect);
	      }

	      return target.takeDamage(atk);
		}//end if
		else
		{
			return ("The attack failed!");

		}
	}//end method
   
   @Override
   public String specialMove(Entity target)
   {
	  if(Math.random() <= (this.accuracy-0.1))
	  {
	   Random rand = new Random();
      Poison poisonEffect = new Poison();
      Attack atk = new Attack();
      atk.addDamage(new Damage(45+rand.nextInt(10), false, "acid"));
      atk.addStatus(poisonEffect);//definitely poison

      return target.takeDamage(atk);
	  }//end if
	  else
	  {
		  return ("The attack failed!");

	  }
   }
   
}//end Basilisk