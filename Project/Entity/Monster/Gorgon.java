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
      setHP(149);//185 too high?
		setPower(30);
      setSpeed(30);
      setAccuracy(0.6);
      setDodge(0.3);
      setDamageReduction(new DamageReduction(10, "cold")); //Vulnerable to cold
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 2.0); //Takes double cold damage
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_GORGON.png");
	}//end method
   
   //Perform attack
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(18, true, "slash")); //mostly claws/bites
      atk.addDamage(new Damage(13, true, "bludgeon"));
      atk.addDamage(new Damage(13, false, "acid"));
      
      Random rand = new Random(); 
      int poisChance = rand.nextInt(5);
      if(poisChance == 3)//small chance for poison
      {
         Poison poisonEffect = new Poison();
         atk.addStatus(poisonEffect);
      }
      
      target.takeDamage(atk);
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
      //Has a random chance of catching a player's gaze and paralyzing them each round?
      Poison poisonEffect = new Poison();
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "slash"));
      atk.addDamage(new Damage(15, true, "bludgeon"));
      atk.addDamage(new Damage(15, false, "acid"));
      atk.addStatus(poisonEffect);//definitely poison
      target.takeDamage(atk);
   }
   
}//end Gorgon