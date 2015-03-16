package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.BurningFlames;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;


public class Lich extends Undead
{
   
   //Create Lich
	public Lich()
	{
		setName("Lich");
      setHP(180);
		setPower(45);
      setSpeed(4);
      setAccuracy(0.6);
      setDodge(0.1);
      setDamageReduction(new DamageReduction(15, "bludgeon")); //Vulnerable to bludgeon
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
      //super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_LICH.png");
	}//end method
   
   //Perform attack
	public void performAttack(Entity target)
	{
	  Random rand = new Random();
	  if(Math.random() <= this.accuracy)
	  {
      Attack atk = new Attack();
      atk.addDamage(new Damage(10+rand.nextInt(5), false, "electric"));
      atk.addDamage(new Damage(10+rand.nextInt(5), false, "cold"));
      atk.addDamage(new Damage(10+rand.nextInt(5), false, "fire"));
      atk.addDamage(new Damage(10+rand.nextInt(5), false, "acid"));
      atk.applyPower(this.power);
      target.takeDamage(atk);
	  }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
	}//end method
   
   /*
   //Summon Undead allows lich to spawn either a zombie, a wraith, or a skeleton
   private Entity summonUndead()
   {
      Random rand = new Random();
      int chanceUndead = rand.nextInt(3);//random 0, 1, or 2
      Entity spawn;
      
      if (chanceUndead == 0)//0 = zombie
      {
         spawn = new Zombie();
         //create zombie and spawn into current encounter
      }
      else if (chanceUndead == 1)//1 = wraith
      {
         spawn = new Wraith();
         //create wraith and spawn into current encounter
      }
      else//2 = skeleton
      {
         spawn = new Skeleton();
         //create skeleton and spawn into current encounter
      }
      
      System.out.println("The Lich has spawned a " + spawn.getName());
      return spawn;
   }*/
   @Override
   public void specialMove(Entity target)
   {
	  Random rand = new Random();
	  if(Math.random() <= this.accuracy-0.15)
	  {
      Attack atk = new Attack();
      atk.addDamage(new Damage(25+rand.nextInt(15), false, "fire"));
      atk.applyPower(this.power);    

      BurningFlames burnEffect = new BurningFlames();
      atk.addStatus(burnEffect);//definitely burn
      target.takeDamage(atk);
      }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
   }
   
}//end Lich