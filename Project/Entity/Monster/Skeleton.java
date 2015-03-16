package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Item.Weapon.WeaponFactory;
import java.util.Random;

public class Skeleton extends Undead
{
   
   //Create Skeleton
	public Skeleton()
	{
		setName("Skeleton");
      setHP(105);
		setPower(25);
      setSpeed(4);
      setAccuracy(0.7);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(5, "bludgeon")); //Vulnerable to bludgeon
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(0, 0.25); //Takes one-quarter cold damage
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_SKELETON.png");
	}//end method
   
   //Perform attack (not wielding a weapon)
	public String performAttack(Entity target)
	{
	  if(Math.random() <= this.accuracy)
	  {
	  Random rand = new Random();	
      Attack atk = new Attack();
      atk.addDamage(new Damage(5+rand.nextInt(15), true, "slash"));
      atk.addDamage(new Damage(10+rand.nextInt(10), true, "bludgeon"));
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
   
   //Perform attack (wielding a weapon)
   @Override
   public String specialMove(Entity target)
   {
	 if(Math.random() <= this.accuracy-0.2)
	 {
      WeaponFactory fact = new WeaponFactory();
      Weapon w = fact.createRandomWeapon();
      Attack atk = w.attack();
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
   
}//end Skeleton