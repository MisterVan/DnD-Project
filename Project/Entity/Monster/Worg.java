package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Behavior.Status.CorrosiveAcid;

public class Worg extends Monster
{
   
   //Create Worg
	public Worg()
	{
		setName("Worg");
      setHP(130);
		setPower(30);
      setSpeed(50);
      setAccuracy(0.8);
      setDodge(0.5);
      setDamageReduction(new DamageReduction(10, "fire")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setFire(0, 1.1); //Takes one and one-tenth fire damage due to fur
      
      setElementalResistance(elRes);
      //super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_WORG.png");
	}//end method
   
   //Perform attack
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(40, true, "slash")); //only able to claw/bite
      target.takeDamage(atk);
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
      //Has a random chance of tripping a target during an attack
      Attack atk = new Attack();
      atk.addDamage(new Damage(40, true, "slash"));
      atk.addDamage(new Damage(5, false, "acid"));
      CorrosiveAcid acidEffect = new CorrosiveAcid();
      atk.addStatus(acidEffect);//definitely poison
      target.takeDamage(atk);
   }
   
}//end Worg