package Project.Entity.Monster;
import java.util.Random;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Wraith extends Entity
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
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(35, false, "cold"));
      atk.addDamage(new Damage(5, false, "wraith"));//If player's HP reaches 0 under this attack, a new wraith is spawned in their place.
      return atk;
	}//end method
   
   //Wraith has chance to phase through attack completely, check each time taking damage
   private void phaseThroughAttack()
   {
      Random rand = new Random(); 
      int chancePhase = rand.nextInt(3); //random 0, 1, 2
      if (chancePhase == 2)
      {
         this.setDodge(1.0);//phases attack
      }
      else
      {
         this.setDodge(0.4);//return original dodge status
      }
   }
   
}//end Wraith