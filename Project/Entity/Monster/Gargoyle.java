package Project.Entity.Monster;

import Project.Behavior.Status.Stoneskin;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Gargoyle extends Monster
{
   //Create Gargoyle
	public Gargoyle()
	{
		setName("Gargoyle");
      setHP(137);
		setPower(30);
      setSpeed(50);
      setAccuracy(0.6);
      setDodge(0.3);
      setDamageReduction(new DamageReduction(10, "nothing")); //Damage reduction unable to be bypassed
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 0.5); //Takes half cold damage
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
     //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_GARGOYLE.png");
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "slash"));//0.5*power + rand.nextInt(11);
      atk.addDamage(new Damage(20, true, "bludgeon"));
      atk.addDamage(new Damage(7, false, "cold"));
      return atk;
	}//end method
   
   @Override
   public Attack specialMove()
   {
      //Gargoyle becomes stone and hits harder while also becoming harder to damage
      Stoneskin gargEffect = new Stoneskin();
      gargEffect.applyEffectToTarget(this);
      
      Attack atk = new Attack();
      atk.addDamage(new Damage(23, true, "slash"));//0.5*power + rand.nextInt(11);
      atk.addDamage(new Damage(23, true, "bludgeon"));
      atk.addDamage(new Damage(10, false, "cold"));
      return atk;
   }
   
}//end Gargoyle