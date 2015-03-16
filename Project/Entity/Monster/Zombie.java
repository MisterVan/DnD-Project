package Project.Entity.Monster;

import Project.Entity.Entity;

import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Behavior.Status.CorrosiveAcid;
import java.util.Random;

public class Zombie extends Undead
{
   
   //Create Basilisk
	public Zombie()
	{
		setName("Zombie");
      setHP(120);
		setPower(20);
      setSpeed(3);
      setAccuracy(0.5);
      setDodge(0.0);
      setDamageReduction(new DamageReduction(5, "slash")); //Vulnerable to slash
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
      
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_ZOMBIE.png");
	}//end method
   
   //Perform attack
   @Override
	public String performAttack(Entity target)
	{
	   if(Math.random() <= this.accuracy)
	   {
		  Random rand = new Random(); 
	      Attack atk = new Attack();
	      atk.addDamage(new Damage(20+rand.nextInt(6), true, "bludgeon"));
	      atk.addDamage(new Damage(5+rand.nextInt(6), true, "slash"));
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
   
   //Zombie spits up stomach acid
   @Override
   public String specialMove(Entity target)
   {
      if(Math.random() <= this.accuracy-0.1)
      {
      Random rand = new Random();
      Attack atk = new Attack();
      atk.addDamage(new Damage(rand.nextInt(10), true, "slash"));
      CorrosiveAcid acidEffect = new CorrosiveAcid();
      atk.addStatus(acidEffect);
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
   }
   
   //Zombie has no special qualities, poor zombie ;__;
   
}//end Zombie