package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Mummy extends Monster
{
   
   //Create Mummy
	public Mummy()
	{
		setName("Mummy");
      setHP(155);
		setPower(30);
      setSpeed(10);
      setAccuracy(0.6);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(10, "fire")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
      //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Hero\\CHARACTER_MONSTER_MUMMY.png");
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(25, true, "bludgeon"));//very strong
      atk.addDamage(new Damage(15, false, "cold"));
      //chance to paralyze with attack
      return atk;
	}//end method
   
   //Mummy's curse, makes player immune to all healing effects until cured (via antidote potion/lift curse)
   @Override
   public Attack specialMove()
   {
      //add boolean 'healable' to heroes class, set to false
      Attack atk = new Attack();
      atk.addDamage(new Damage(10, false, "mummy's curse"));
      System.out.println("Player is unable to be healed!");
      return atk;
   }
   
}//end Mummy