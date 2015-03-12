package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.Frostbite;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Wraith extends Monster
{
   
   //Create Wraith
	public Wraith()
	{
		setName("Wraith");
      setHP(132);
		setPower(30);
      setSpeed(30);
      setAccuracy(0.6);
      setDodge(0.4);//can have %100 dodge, random chance to 'phase through' attack completely
      setDamageReduction(new DamageReduction(20, "fire")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(0, 0.5); //Takes half cold damage
      setElementalResistance(elRes);
      
      //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_WRAITH.png");
	}//end method
   
   @Override
   public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(35, false, "cold"));
      atk.addDamage(new Damage(5, false, "wraith"));//If player's HP reaches 0 under this attack, a new wraith is spawned in their place.
      return atk;
	}//end method
   
   //CHECK EACH ROUND
   //Wraith has chance to phase through attack completely, check each time taking damage
   @Override
   public Attack specialMove()
   {
      Attack atk = new Attack();
      atk.addDamage(new Damage(35, false, "cold"));
      atk.addDamage(new Damage(5, false, "wraith"));
      Frostbite frostEffect = new Frostbite();
      atk.addStatus(frostEffect);
      return atk;
   }
   
   @Override
   public void takeDamage(Attack atk)
   {
      int actualDamage = 0;
      
      Random rand = new Random();
      int chancePhase = rand.nextInt(3); //random 0, 1, 2
      if (chancePhase == 2)
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