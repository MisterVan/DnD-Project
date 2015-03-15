package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.Frostbite;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Wraith extends Undead
{
   
   //Create Wraith
	public Wraith()
	{
		setName("Wraith");
      setHP(130);
		setPower(30);
      setSpeed(4);
      setAccuracy(0.6);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(20, "fire")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(20, 0.5); //Takes half cold damage
      setElementalResistance(elRes);
      
      //super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_WRAITH.png");
	}//end method
   
   @Override
   public void performAttack(Entity target)
	{
	  if(Math.random() <= this.accuracy)
	  {
      Attack atk = new Attack();
      Random rand = new Random();
      atk.addDamage(new Damage(25+rand.nextInt(11), false, "cold"));
      atk.addDamage(new Damage(5+rand.nextInt(11), false, "slash"));
      target.takeDamage(atk);
	  }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
	}//end method
   
   //CHECK EACH ROUND

   @Override
   public void specialMove(Entity target)
   {
	  if(Math.random() <= this.accuracy - 0.2)
	  {
	  Random rand = new Random(); 
      Attack atk = new Attack();
      atk.addDamage(new Damage(35+rand.nextInt(16), false, "cold"));
      atk.addDamage(new Damage(5+rand.nextInt(11), false, "slash"));
      Frostbite frostEffect = new Frostbite();
      atk.addStatus(frostEffect);
      atk.applyPower(this.power);
      target.takeDamage(atk);
	  }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
   }
   
   @Override
   public void takeDamage(Attack atk)
   {
      int actualDamage = 0;
      
      Random rand = new Random();
      int chancePhase = rand.nextInt(3); //random 0, 1, 2
      if(Math.random() <= this.dodge)
    		  {
    	  		System.out.println("The wraith dodged the attack!");
    	  		return;
    		  }
      else if (chancePhase == 2)
      {
         System.out.println("The Wraith phased through the attack!");
         return;//phases attack
      }
   
      for(Damage dmg : atk.getDamage())
      {
         if(dmg.isPhysical())
         {
            actualDamage = dr.processDamage(dmg);
            this.hp -= actualDamage;
            System.out.println(this.name + " took " + actualDamage + " points of " + dmg.getDamageType() + " damage"); //This print is just used for feedback in testing
         }
      else//it's magical
      { 
         actualDamage = er.processDamage(dmg);
         this.hp -= actualDamage;
         System.out.println(this.name + " took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
      }
     }
      
      if(atk.hasStatus())
         this.giveStatus(atk.deliverStatus());
   }//end method
      
}//end Wraith