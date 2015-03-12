package Project.Entity.Monster;

import Project.Behavior.Status.Poison;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class ChimeraSkeleton extends Monster
{
   
   //Create ChimeraSkeleton
	public ChimeraSkeleton()
	{
		setName("ChimeraSkeleton");
      setHP(166);
		setPower(30);
      setSpeed(40);
      setAccuracy(0.8);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(15, "bludgeon")); //Vulnerable to electricity
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
      //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_CHIMERASKELETON.png");
	}//end method
   
   //Perform attack
   @Override
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "slash")); //lion uses claws/bite from snake
      atk.addDamage(new Damage(8, false, "fire")); //goat gives magical abilities?
      atk.addDamage(new Damage(8, false, "cold")); //goat gives magical abilities?
      return atk;
	}//end method
   
   @Override
   public Attack specialMove()
   {
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, false, "acid")); //snake/chance for poison
      Poison poisonEffect = new Poison();
      atk.addStatus(poisonEffect);
      
      return atk;
   }
   
}//end ChimeraSkeleton