package Project.Entity.Monster;
import java.util.Random;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

import Project.Entity.Monster.Zombie;
import Project.Entity.Monster.Wraith;
import Project.Entity.Monster.Skeleton;

public class Lich extends Entity
{
   
   //Create Lich
	public Lich()
	{
		setName("Lich");
      setHP(136);
		setPower(30);
      setSpeed(20);
      setAccuracy(0.7);
      setDodge(0.3);
      setDamageReduction(new DamageReduction(20, "bludgeon")); //Vulnerable to bludgeon
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(10, false, "electric"));
      atk.addDamage(new Damage(10, false, "cold"));
      atk.addDamage(new Damage(10, false, "fire"));
      atk.addDamage(new Damage(10, false, "acid"));
      //chance to paralyze within melee distance?
      return atk;
	}//end method
   
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
   }
   
}//end Lich