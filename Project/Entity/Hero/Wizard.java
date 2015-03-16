package Project.Entity.Hero;

import java.util.Scanner;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Behavior.Status.BurningFlames;
import Project.Behavior.Status.CorrosiveAcid;
import Project.Behavior.Status.Frostbite;
import Project.Behavior.Status.ElectricalSurge;
import java.util.Random;

public class Wizard extends Hero
{
   //Create Wizard
	public Wizard()
	{
		setName("Wizard");
      setHP(250);
      setPower(35);
      setSpeed(4);
      setAccuracy(0.5);
      setDodge(0.05);
      setDamageReduction(new DamageReduction(0, "-"));//No special armor, not reducing any damage physically
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 0.8);
      elRes.setFire(0, 0.8);
      elRes.setAcid(0, 0.8);
      elRes.setElec(0, 0.8);//takes %20 less of all magical damage
      setElementalResistance(elRes);
      Weapon staff = new Weapon("Staff", "bludgeon", 4, 10);
      setPrimaryWpn(staff);
      Weapon dagger = new Weapon("Dagger", "slash,pierce", 20, 25);
      this.inventory.add(0, dagger); //Wizard relies on spells
      super.setSprite("Project\\Sprites\\Characters\\Hero\\CHARACTER_HERO_WIZARD.png");
	}//end method
   
   @Override
<<<<<<< HEAD
   public String specialMove(Entity target)
=======
   public void specialMove(Entity target)
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
   {
      //Wizard able to have more specific/powerful spells? idk
      Scanner kb = new Scanner(System.in);
      int ans = 0;
      Random rand = new Random();
      
      ans = rand.nextInt(4) + 1;
      Attack atk = new Attack();
      if (ans == 1)
      {
         atk.addDamage(new Damage(60+rand.nextInt(20), false, "cold"));//randogen later
         atk.addStatus(new Frostbite());
      }
      else if (ans == 2)
      {
         atk.addDamage(new Damage(60+rand.nextInt(20), false, "fire"));//randogen later
         atk.addStatus(new BurningFlames());
      }
      else if (ans == 3)
      {
         atk.addDamage(new Damage(60+rand.nextInt(20), false, "electric"));//randogen later
         atk.addStatus(new ElectricalSurge());
      }
      else if (ans == 4)
      {
         atk.addDamage(new Damage(60+rand.nextInt(20), false, "acid"));//randogen later
         atk.addStatus(new CorrosiveAcid());
      }
      atk.applyPower(super.power);
<<<<<<< HEAD
      return target.takeDamage(atk);
=======
      target.takeDamage(atk);
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
   }
   
   @Override
   public String getSpecialName() 
   {
	   return "Special: Cast Spell";
   }
   
   @Override
   public String getSpecialDescription()
   {
	   return "Cast one of many powerful spells at the target.";
   }
   
}//end Wizard