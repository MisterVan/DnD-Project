package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Behavior.Status.Poison;
import java.util.Random;

public class Worg extends Monster
{
   
   //Create Worg
	public Worg()
	{
		setName("Worg");
      setHP(90);
		setPower(20);
      setSpeed(6);
      setAccuracy(0.7);
      setDodge(0.3);
      setDamageReduction(new DamageReduction(0, "-")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setFire(0, 1.2); //Takes one and one-tenth fire damage due to fur
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_WORG.png");
	}//end method
   
   //Perform attack
	public String performAttack(Entity target)
	{
	 if(Math.random() <= this.accuracy)	
	 {
	  Random rand = new Random();
      Attack atk = new Attack();
      atk.addDamage(new Damage(10+rand.nextInt(15), true, "slash")); //only able to claw/bite
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
	  Random rand = new Random();
	  if(Math.random() <= this.accuracy-0.15)
	  {
      Attack atk = new Attack();
      atk.addDamage(new Damage(35+rand.nextInt(15), true, "slash"));
      atk.addStatus(new Poison());//definitely poison
      atk.applyPower(this.power);
<<<<<<< HEAD
      return target.takeDamage(atk);
	  }
	  else {
		  return ("The attack failed!");
=======
      target.takeDamage(atk);
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	  }
   }
   
}//end Worg