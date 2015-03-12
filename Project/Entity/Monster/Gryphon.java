package Project.Entity.Monster;

import Project.Behavior.Status.Blur;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Gryphon extends Monster
{
   
   //Create Gryphon
	public Gryphon()
	{
		setName("Gryphon");
      setHP(159);
		setPower(30);
      setSpeed(40);
      setAccuracy(0.7);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(15, "slash")); //Vulnerable to slash
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 2.0); //Takes double cold damage
      elRes.setElec(0, 1.5); //Takes one and a half electric damage
      
      setElementalResistance(elRes);
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_GRYPHON.png");
	}//end method
   
   //Perform attack
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, true, "slash")); //mostly claws/bites
      atk.addDamage(new Damage(20, true, "bludgeon"));
      target.takeDamage(atk);
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
      //Gryphon uses wings to dodge more quickly for a number of rounds using blur effect
      Blur flyEffect = new Blur();
      flyEffect.applyEffectToTarget(this);
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, true, "slash")); //mostly claws/bites
      atk.addDamage(new Damage(20, true, "bludgeon"));
      target.takeDamage(atk);
   }
   
}//end Gryphon