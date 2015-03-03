package Project.Vampire;

import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;

public class Vampire extends Entity
{
   
   //Create Vampire
	public Vampire()
	{
		setName("Vampire");
      setHP(130);
		setPower(30);
      setSpeed(40);
      setAccuracy(0.7);
      setDodge(0.5);
      setDamageReduction(new DamageReduction(10, "fire")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(0, 0.5); //Takes half cold damage
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(15, true, "slash"));//bite
      atk.addDamage(new Damage(15, true, "bludgeon"));//superhuman strength
      atk.addDamage(new Damage(5, false, "acid"));//venom
      this.setHP(this.getHP()+5);//regains a small amount of health each round
      return atk;
	}//end method
   
   //Vampire has chance to 'absorb' health from opponent, dealing damage and healing itself
   private Attack absorbHealth()
   {
      //absorb health
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, false, "health-drain"));
      this.setHP(this.getHP()+30);
      return atk;
   }
   
}//end Vampire