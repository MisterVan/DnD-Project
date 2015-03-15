package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.Poison;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

//After at least 50 pts in slash damage have been taken, the tail is considered 'cut off'. boolean for snake gone
//Speed is reduced by 10 pts, accuracy is reduced by 0.2, chance to poison is lost.
public class Chimera extends Monster
{
   
   //Create Chimera
	public Chimera()
	{
		setName("Chimera");
      setHP(176);
	  setPower(35);
      setSpeed(5);
      setAccuracy(0.6);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(10, "electric")); //Vulnerable to electricity
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setElec(0, 2.0); //Takes double electric damage
      
      setElementalResistance(elRes);
      super.setSprite("\\Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_CHIMERA.png");
	}//end method
   
   //Perform attack
   @Override
	public void performAttack(Entity target)
	{
	  if(Math.random() <= this.accuracy)
	  {
      Attack atk = new Attack();
      Random rand = new Random();
      atk.addDamage(new Damage(10 + rand.nextInt(5), true, "slash")); //lion uses claws/bite
      atk.addDamage(new Damage(3 + rand.nextInt(5), false, "fire")); //goat gives magical abilities?
      atk.addDamage(new Damage(3 + rand.nextInt(5), false, "cold")); //goat gives magical abilities?
      atk.addDamage(new Damage(10 + rand.nextInt(10), false, "acid")); //snake/chance for poison
      atk.applyPower(super.power);
	  
 
      int poisChance = rand.nextInt(5);
      if(poisChance == 3)//small chance for poison
      {
         Poison poisonEffect = new Poison();
         atk.addStatus(poisonEffect);
      }
      
      target.takeDamage(atk);
	  }//end if
	  else
	  {
		  System.out.println("The attack failed!");
	  }
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
	   if(Math.random() <= (this.accuracy-0.15))
	   {
	   Random rand = new Random();
      //Snake attack, definite poison and slash/acid damage
      Attack atk = new Attack();
      atk.addDamage(new Damage(10 + rand.nextInt(5), true, "pierce"));
      atk.addDamage(new Damage(8 + rand.nextInt(5), false, "acid"));
      atk.applyPower(super.power);
      Poison poisonEffect = new Poison();
      atk.addStatus(poisonEffect);
      
      target.takeDamage(atk);
	   }//end if
	   else
	   {
		   System.out.println("The attack failed!");
	   }
   }
   
}//end Chimera