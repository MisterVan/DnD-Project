package Project.Entity.Monster;

import Project.Entity.Entity;

import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Behavior.Status.CorrosiveAcid;

public class Zombie extends Monster
{
   
   //Create Basilisk
	public Zombie()
	{
		setName("Zombie");
      setHP(116);
		setPower(30);
      setSpeed(10);
      setAccuracy(0.5);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(8, "slash")); //Vulnerable to slash
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
      
      //super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_ZOMBIE.png");
	}//end method
   
   //Perform attack
   @Override
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(20, true, "bludgeon"));
      atk.addDamage(new Damage(5, true, "slash"));
      target.takeDamage(atk);
	}//end method
   
   //Zombie spits up stomach acid
   @Override
   public void specialMove(Entity target)
   {
      System.out.println("The Zombie spit up stomach acid!");
      Attack atk = new Attack();
      CorrosiveAcid acidEffect = new CorrosiveAcid();
      atk.addStatus(acidEffect);
      target.takeDamage(atk);
   }
   
   //Zombie has no special qualities, poor zombie ;__;
   
}//end Zombie