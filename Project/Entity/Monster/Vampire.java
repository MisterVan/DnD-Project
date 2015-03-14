package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Vampire extends Monster
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
      //super.setSprite("\Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_VAMPIRE.png");
	}//end method
   
   //Perform attack
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(15, true, "slash"));//bite
      atk.addDamage(new Damage(15, true, "bludgeon"));//superhuman strength
      atk.addDamage(new Damage(5, false, "acid"));//venom
      this.setHP(this.getHP()+5);//regains a small amount of health each round
      target.takeDamage(atk);
	}//end method
   
   //Vampire has chance to 'absorb' health from opponent, dealing damage and healing itself
   @Override
   public void specialMove(Entity target)
   {
      //absorb health
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, false, "untyped"));
      this.setHP(this.getHP()+30);
      target.takeDamage(atk);
   }
   
}//end Vampire