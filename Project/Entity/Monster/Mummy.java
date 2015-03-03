package Project.Mummy;

import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;

public class Mummy extends Entity
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
   private Attack mummysCurse()
   {
      //add boolean 'healable' to heroes class, set to false
      Attack atk = new Attack();
      atk.addDamage(new Damage(10, false, "mummy's curse"));
      System.out.println("Player is unable to be healed!");
      return atk;
   }
   
}//end Mummy