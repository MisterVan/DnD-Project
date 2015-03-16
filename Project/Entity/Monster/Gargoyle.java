package Project.Entity.Monster;

import Project.Behavior.Status.Stoneskin;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

public class Gargoyle extends Monster
{
   //Create Gargoyle
	public Gargoyle()
	{
		setName("Gargoyle");
      setHP(130);
		setPower(30);
      setSpeed(3);
      setAccuracy(0.6);
      setDodge(0.1);
      setDamageReduction(new DamageReduction(10, "-")); //Damage reduction unable to be bypassed
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 0.5); //Takes half cold damage
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
     super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_GARGOYLE.png");
	}//end method
   
   //Perform attack
	public String performAttack(Entity target)
	{
	if(Math.random() <= this.accuracy)
	{
	  Random rand = new Random();
      Attack atk = new Attack();
      atk.addDamage(new Damage(15+rand.nextInt(8), true, "slash"));//0.5*power + rand.nextInt(11);
      atk.addDamage(new Damage(15+rand.nextInt(8), true, "bludgeon"));
      atk.applyPower(this.power);

      return target.takeDamage(atk);
	}
	else
	{
		return ("The attack failed!");

	}
	}//end method
   
   @Override
   public String specialMove(Entity target)
   {
      //Gargoyle becomes stone and hits harder while also becoming harder to damage
      Stoneskin gargEffect = new Stoneskin();
      this.giveStatus(gargEffect);
      Random rand = new Random();
      
      if(Math.random() <= this.accuracy-0.1)
      {
      Attack atk = new Attack();
      atk.addDamage(new Damage(30+rand.nextInt(15), true, "slash"));//0.5*power + rand.nextInt(11);
      atk.applyPower(this.power);

      return target.takeDamage(atk);
      }
      else
      {
    	  return ("The attack failed!");

      }
   }
   
}//end Gargoyle