package Project.Entity.Monster;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Gargoyle extends Entity
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
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(25, true, "slash"));//0.5*power + rand.nextInt(11);
      atk.addDamage(new Damage(20, true, "bludgeon"));
      atk.addDamage(new Damage(7, false, "cold"));
      return atk;
	}//end method
   
   private void statueMove()
   {
      //random boolean deciding whether gargoyle begins in statue state or is already active?
      //if in statue state, waits until player is within (randomly generated) 2-6ft distance before becoming active
   }
   
}//end Gargoyle