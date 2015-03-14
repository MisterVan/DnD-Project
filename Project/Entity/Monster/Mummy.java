package Project.Entity.Monster;

import java.util.Random;
import Project.Behavior.Status.Blind;
import Project.Behavior.Status.Might;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Mummy extends Monster
{
   
   //Create Mummy
	public Mummy()
	{
		setName("Mummy");
      setHP(155);
		setPower(30);
      setSpeed(10);
      setAccuracy(0.6);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(10, "fire")); //Vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 2.0); //Takes double fire damage
      
      setElementalResistance(elRes);
      //super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_MUMMY.png");
	}//end method
   
   //Perform attack
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(25, true, "bludgeon"));//very strong
      atk.addDamage(new Damage(15, false, "cold"));
      //chance to paralyze with attack
      target.takeDamage(atk);
	}//end method
   
   //Mummy's curse, makes player immune to all healing effects briefly?
   @Override
   public void specialMove(Entity target)
   {
      Might mumEffect = new Might();
      mumEffect.applyEffectToTarget(this);
      
      Attack atk = new Attack();
      atk.addDamage(new Damage(10, false, "mummy's curse"));
      
      //chance for blind
      Random rand = new Random(); 
      int blindChance = rand.nextInt(5);
      if(blindChance == 3)
      {
         Blind blindEffect = new Blind();
         atk.addStatus(blindEffect);
      }
      
      //System.out.println("Player is unable to be healed!");
      target.takeDamage(atk);
   }
   
}//end Mummy