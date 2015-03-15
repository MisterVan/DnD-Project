package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

public class Vampire extends Undead
{
   
   //Create Vampire
	public Vampire()
	{
	  setName("Vampire");
      setHP(130);
	  setPower(30);
      setSpeed(5);
      setAccuracy(0.7);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(10, "silver")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(10, 0.5); //Takes half cold damage
      elRes.setFire(0, 1.5); //Takes one and a half fire damage
      
      setElementalResistance(elRes);
      //super.setSprite("\Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_VAMPIRE.png");
	}//end method
   
   //Perform attack
	public void performAttack(Entity target)
	{
		if(Math.random() <= this.accuracy)
		{
		  Random rand = new Random();
	      Attack atk = new Attack();
	      atk.addDamage(new Damage(15+rand.nextInt(10), true, "slash"));//bite
	      atk.applyPower(this.power);
	      this.setHP(this.getHP()+5+rand.nextInt(6));//regains a small amount of health each attack
	      target.takeDamage(atk);
		}//end if
		else
		{
			System.out.println("The attack failed!");
		}
	}//end method
   
   //Vampire has chance to 'absorb' health from opponent, dealing damage and healing itself
   @Override
   public void specialMove(Entity target)
   {
      //absorb health
	  if(Math.random() <= this.accuracy - 0.2)
	  {
	  Random rand = new Random();
      Attack atk = new Attack();
      atk.addDamage(new Damage(30+rand.nextInt(11), false, "untyped"));
      this.setHP(this.getHP()+30+rand.nextInt(21));
      atk.applyPower(this.power);
      target.takeDamage(atk);
	  }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
   }
   
}//end Vampire