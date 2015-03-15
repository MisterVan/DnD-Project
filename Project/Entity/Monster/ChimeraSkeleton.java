package Project.Entity.Monster;

import Project.Behavior.Status.Poison;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

public class ChimeraSkeleton extends Undead
{
   
   //Create ChimeraSkeleton
	public ChimeraSkeleton()
	{
		setName("ChimeraSkeleton");
      setHP(200);
	  setPower(30);
      setSpeed(3);
      setAccuracy(0.6);
      setDodge(0.1);
      setDamageReduction(new DamageReduction(15, "bludgeon")); 
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
      //super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_CHIMERASKELETON.png");
	}//end method
   
   //Perform attack
   @Override
	public void performAttack(Entity target)
	{
	  if(Math.random() <= this.accuracy)
	  {
	  Random rand = new Random();
      Attack atk = new Attack();
      atk.addDamage(new Damage(25 + rand.nextInt(10), true, "slash")); //lion uses claws/bite from snake
      atk.addDamage(new Damage(10 + rand.nextInt(5), false, "fire")); //goat gives magical abilities?
      atk.addDamage(new Damage(10 + rand.nextInt(5), false, "cold")); //goat gives magical abilities?
      atk.applyPower(super.power);
      target.takeDamage(atk);
	  }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
	 if(Math.random() <= this.accuracy)  
	 {
	      Attack atk = new Attack();
	      Random rand = new Random();
	      atk.addDamage(new Damage(30 + rand.nextInt(20), false, "acid")); //snake/chance for poison
	      atk.applyPower(super.power);
	      Poison poisonEffect = new Poison();
	      atk.addStatus(poisonEffect);
	      
	     target.takeDamage(atk);
	 }//end if
	 else
	 {
		System.out.println("The attack failed!"); 
	 }
	 
   }
   
}//end ChimeraSkeleton