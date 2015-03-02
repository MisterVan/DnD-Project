package Project.Entity.Hero;

import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;
import Project.Weapon.Weapon;


public class Fighter extends Hero
{
   //Create Fighter
	public Fighter()
	{
		setName("Fighter");
      setHP(150);
		setPower(12);//damage multiplier for attack object first damage type
      setSpeed(50);
      setAccuracy(0.7);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(18, "acid,fire"));
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 0.8);//used to being outside?
      //elRes.setFire(0, 0.0);
      //elRes.setAcid(0, 0.0);
      //elRes.setElec(0, 0.0);
      setElementalResistance(elRes);
      Weapon sword = new Weapon("Sword", "slash,pierce,metalline", 30, 45);
      setPrimaryWpn(sword);
      Weapon dagger = new Weapon("Dagger", "slash,pierce", 20, 25);
      setSecondaryWpn(dagger);
	}//end method
   
   public Attack specialMove()
   {
      //Fighter might be able to equip some basic spells? Now electricute for funsies. Can change later.
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, false, "electric"));//randogen later
      return atk;
   }
   
}//end Fighter