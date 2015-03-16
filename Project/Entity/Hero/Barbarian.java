package Project.Entity.Hero;

import Project.Entity.Entity;
import Project.Behavior.Status.Stoneskin;
import Project.Behavior.Status.Might;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;

public class Barbarian extends Hero
{
   //Create Barbarian
	public Barbarian()
	{
	  setName("Barbarian");
      setHP(500);
      setPower(70);
      setSpeed(7);
      setAccuracy(0.7);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(5, "-"));//Can shrug off some damage from any physical attack
      ElementalResistance elRes = new ElementalResistance();
      elRes.setFire(0, 1.2); //Vulnerable to fire due to having most flesh being bare.
      elRes.setCold(0, 0.8);
      elRes.setElec(0, 0.9);
      setElementalResistance(elRes);
      Weapon mace = new Weapon("Mace", "bludgeon", 8, 15);
      setPrimaryWpn(mace);
      this.inventory.add(0, new Weapon("Axe", "slash", 4, 20));
      super.setSprite("Project\\Sprites\\Characters\\Hero\\CHARACTER_HERO_BARBARIAN.png");
	}//end method
   
   @Override
   public String specialMove(Entity target)
   {
      //Barbarian applies stoneskin to self for 3 rounds and gives a first initial brute strength attack
	   
      Stoneskin stoneEffect = new Stoneskin();
      Might mightEffect = new Might();
      
      this.giveStatus(stoneEffect);
      this.giveStatus(mightEffect);
      
      int lostHealth = this.hp/10; //Note: at 1 hp this value is 0, that is, this move can never kill you
      Damage dmg = new Damage(lostHealth, false, "untyped"); //Untyped, so that damage reduction can't affect it
      Attack atk = new Attack();
      atk.addDamage(dmg);

      return this.takeDamage(atk);

   }
   
   @Override
   public String getSpecialName()
   {
	   return "Special: Barbarian Rage";
   }
   
   @Override
   public String getSpecialDescription()
   {
	   return "Release an incredible burst of power, shrugging \noff physical blows and dealing increased damage at the cost of some health.";
   }
   
}//end Barbarian