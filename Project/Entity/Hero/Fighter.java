package Project.Entity.Hero;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import java.util.Random;


public class Fighter extends Hero
{
   //Create Fighter
	public Fighter()
	{
		setName("Fighter");
      setHP(380);
		setPower(50);//damage multiplier for attack object first damage type
      setSpeed(6);
      setAccuracy(0.8);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(8, "pierce"));
      ElementalResistance elRes = new ElementalResistance();      
      setElementalResistance(elRes);
      Weapon sword = new Weapon("Longsword", "slash", 8, 15);
      setPrimaryWpn(sword);
<<<<<<< HEAD
      Weapon dagger = new Weapon("Dagger", "slash,pierce", 20, 25);
      this.inventory.add(0, dagger);
=======
      this.inventory.add(0, new Weapon("Scimitar", "slash", 7, 16));
>>>>>>> 407b314f7272ac140b255f56c202c12f0a01ac55
      super.setSprite("Project\\Sprites\\Characters\\Hero\\CHARACTER_HERO_FIGHTER.png");
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
	   Random rand = new Random();
	   
      //Fighter might be able to equip some basic spells? Now electricute for funsies. Can change later.
      Attack atk = super.primaryWpn.attack();
      int missingHP = super.baseHP - super.hp;
      atk.addDamage(new Damage(missingHP + rand.nextInt(11), false, "untyped"));
      atk.applyPower(super.power);
      target.takeDamage(atk);
   }
   
   @Override
   public String getSpecialName()
   {
	   return "Special: Persevering Strike";
   }
   
   @Override
   public String getSpecialDescription()
   {
	   return "Unleash a powerful strike that becomes stronger the less health you have.";
   }
}//end Fighter