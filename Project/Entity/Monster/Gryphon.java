package Project.Entity.Monster;

import Project.Behavior.Status.Blur;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

public class Gryphon extends Monster
{
   
   //Create Gryphon
	public Gryphon()
	{
		setName("Gryphon");
      setHP(180);
		setPower(30);
      setSpeed(6);
      setAccuracy(0.7);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(5, "slash,pierce")); //Vulnerable to slash
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 2.0); //Takes double cold damage
      elRes.setElec(0, 1.5); //Takes one and a half electric damage
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_GRYPHON.png");
	}//end method
   
   //Perform attack
	public String performAttack(Entity target)
	{
		if(Math.random() <= this.accuracy)
		{
			Random rand = new Random();
	      Attack atk = new Attack();
	      atk.addDamage(new Damage(20+rand.nextInt(10), true, "slash")); //mostly claws/bites
	      atk.addDamage(new Damage(5+rand.nextInt(10), true, "bludgeon"));
	      atk.applyPower(this.power);
<<<<<<< HEAD
	      return target.takeDamage(atk);
		}
		else
		{
			return ("The attack failed!");
=======
	      target.takeDamage(atk);
		}
		else
		{
			System.out.println("The attack failed!");
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
		}
	}//end method
   
   @Override
   public String specialMove(Entity target)
   {
      //Gryphon uses wings to dodge more quickly for a number of rounds using blur effect
      Blur flyEffect = new Blur();
      this.giveStatus(flyEffect);
      if(Math.random() <= (this.accuracy - 0.2))
      {
      Random rand = new Random();
      Attack atk = new Attack();
      atk.addDamage(new Damage(5 + rand.nextInt(5) , true, "slash")); //mostly claws/bites
      atk.addDamage(new Damage(5 + rand.nextInt(5), true, "bludgeon"));
      atk.applyPower(this.power/2); //We want damage to be lowish considering it also buffs
<<<<<<< HEAD
      return target.takeDamage(atk);
      }
      else
      {
    	  return ("The attack failed!");
=======
      target.takeDamage(atk);
      }
      else
      {
    	  System.out.println("The attack failed!");
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
      }
   }
   
}//end Gryphon