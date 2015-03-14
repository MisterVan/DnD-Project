package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;

public class Skeleton extends Monster
{
   
   //Create Skeleton
	public Skeleton()
	{
		setName("Skeleton");
      setHP(106);
		setPower(30);
      setSpeed(25);
      setAccuracy(0.7);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(10, "bludgeon")); //Vulnerable to bludgeon
      ElementalResistance elRes = new ElementalResistance();  
      elRes.setCold(0, 0.25); //Takes one-quarter cold damage
      
      setElementalResistance(elRes);
      //super.setSprite"Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_SKELETON.png");
	}//end method
   
   //Perform attack (not wielding a weapon)
	public void performAttack(Entity target)
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(15, true, "slash"));
      atk.addDamage(new Damage(15, true, "bludgeon"));
      target.takeDamage(atk);
	}//end method
   
   //Perform attack (wielding a weapon)
   @Override
   public void specialMove(Entity target)
   {
      //Skeleton is able to wield a weapon and attack another player.
      Weapon club = new Weapon("Club", "bludgeon", 25, 35);
      target.takeDamage(club.attack());
   }
   
}//end Skeleton