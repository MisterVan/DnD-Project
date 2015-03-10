package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Basilisk extends Monster
{
   
   //Create Basilisk
	public Basilisk()
	{
		setName("Basilisk");
      setHP(145);
		setPower(30);
      setSpeed(20);
      setAccuracy(0.7);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(10, "cold")); //Vulnerable to cold
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(0, 2.0); //Takes double cold damage    
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
      //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Hero\\CHARACTER_MONSTER_BASILISK.png");
	}//end method
   
   //Perform attack
	@Override
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "slash"));
      atk.addDamage(new Damage(5, true, "bludgeon"));
      atk.addDamage(new Damage(20, false, "acid")); //chance for poison
      return atk;
	}//end method
   
   @Override
   public Attack specialMove()
   {
      //Has a random chance of catching a player's gaze and paralyzing them each round
      return null;
   }
   
}//end Basilisk