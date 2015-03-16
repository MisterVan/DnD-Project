package Project.Entity.Monster;

import java.util.Random;
import Project.Behavior.Status.Blind;
import Project.Behavior.Status.Might;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Mummy extends Undead
{
   
   //Create Mummy
	public Mummy()
	{
		setName("Mummy");
      setHP(155);
		setPower(30);
      setSpeed(2);
      setAccuracy(0.5);
      setDodge(0.0);
      setDamageReduction(new DamageReduction(5, "slash,pierce")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_MUMMY.png");
	}//end method
   
   //Perform attack
	public String performAttack(Entity target)
	{
	  Random rand = new Random();
	  if(Math.random() <= this.accuracy)
	  {
      Attack atk = new Attack();
      atk.addDamage(new Damage(25+rand.nextInt(11), true, "bludgeon"));//very strong
      atk.addDamage(new Damage(15+rand.nextInt(5), false, "cold"));
      //chance to paralyze with attack
      atk.applyPower(this.power);
      return target.takeDamage(atk);
	  }
	  else
	  {
		  return ("The attack failed!");
	  }
	}//end method
   
   //Mummy's curse, makes player immune to all healing effects briefly?
   @Override
   public String specialMove(Entity target)
   {
      Might mumEffect = new Might();
      this.giveStatus(mumEffect);
      Random rand = new Random();
      
      if(Math.random() <= this.accuracy-0.2)
      {
      
      Attack atk = new Attack();
      atk.addDamage(new Damage(10+rand.nextInt(11), false, "untyped"));

      Blind blindEffect = new Blind();
      atk.addStatus(blindEffect);
      atk.applyPower(this.power);
      return target.takeDamage(atk);
      }
      else
      {
    	  return ("The attack failed!");
      }
   }
   
}//end Mummy