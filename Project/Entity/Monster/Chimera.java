package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Chimera extends Entity
{
   
   //Create Chimera
	public Chimera()
	{
		setName("Chimera");
      setHP(176);
		setPower(30);
      setSpeed(40);
      setAccuracy(0.8);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(10, "electric")); //Vulnerable to electricity
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setElec(0, 2.0); //Takes double electric damage
      
      setElementalResistance(elRes);
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "slash")); //lion uses claws/bite
      atk.addDamage(new Damage(8, false, "fire")); //goat gives magical abilities?
      atk.addDamage(new Damage(8, false, "cold")); //goat gives magical abilities?
      atk.addDamage(new Damage(20, false, "acid")); //snake/chance for poison
      return atk;
	}//end method
   
   private void loseTail()
   {
      //After at least 50 pts in slash damage have been taken, the tail is considered 'cut off'. boolean for snake gone
      //Speed is reduced by 10 pts, accuracy is reduced by 0.2, chance to poison is lost.
   }
   
}//end Chimera