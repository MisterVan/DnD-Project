package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.Poison;
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
      super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_BASILISK.png");
	}//end method
   
   //Perform attack
	@Override
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(15, true, "slash"));
      atk.addDamage(new Damage(5, true, "bludgeon"));
      atk.addDamage(new Damage(20, false, "acid"));
      
      Random rand = new Random(); 
      int poisChance = rand.nextInt(5);
      if(poisChance == 3)//small chance for poison
      {
         Poison poisonEffect = new Poison();
         atk.addStatus(poisonEffect);
      }
      
      target.takeDamage(atk);
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
      Poison poisonEffect = new Poison();
      Attack atk = new Attack();
      atk.addDamage(new Damage(45, false, "acid"));
      atk.addStatus(poisonEffect);//definitely poison
      target.takeDamage(atk);
   }
   
}//end Basilisk