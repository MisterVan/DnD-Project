package Project.Entity.Hero;

import java.util.Scanner;

import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Entity.Entity;
import java.util.Random;
import Project.Behavior.Status.Regeneration;
import Project.Behavior.Status.StatusEffect;

public class Cleric extends Hero
{
   //Create Cleric
	public Cleric()
	{
	  setName("Cleric");
      setHP(200); //Very squishy,  but valuable because he can heal
	  setPower(30);
      setSpeed(4);
      setAccuracy(0.6);
      setDodge(0.1);
      setDamageReduction(new DamageReduction(3, "slash,pierce"));
      ElementalResistance elRes = new ElementalResistance();
      elRes.setAcid(10, 0.9);
      elRes.setFire(0, 1.1);
      elRes.setCold(10, 0.8);
      elRes.setElec(10, 0.9);
      setElementalResistance(elRes);
      Weapon fists = new Weapon("Fists", "bludgeon", 4, 8);
      setPrimaryWpn(fists);
      this.inventory.add(0, new Weapon("Dagger", "pierce", 4, 10));//Cleric relies on spells
      super.setSprite("Project\\Sprites\\Characters\\Hero\\CHARACTER_HERO_CLERIC.png");
	}//end method
   
   @Override
   public String specialMove(Entity target)
   {
	  Random rand = new Random();
	  
	  StatusEffect regen = new Regeneration();
	  
	  target.recoverHP(rand.nextInt(100) + 200); //200-299 hp
	  this.giveStatus(regen);
	  return "";
      /*//Cleric uses healing spells, applicable towards teammates and monsters (undead take damage from healing/holy spells)
      Scanner kb = new Scanner(System.in);
      int ans = 0;
      
      while ((ans != 1)&&(ans != 2)&&(ans != 3)&&(ans != 4))
      {
         System.out.println("Cleric: \n1 - Heal Self \n2 - Heal Party Member \n3 - Holy Blessing \n");
         ans = kb.nextInt();
      }
      
      Attack atk = new Attack();
      if (ans == 1)//give self HP
      {
         int newHP = this.getHP() + 25;//randogen later
         this.setHP(newHP);
      }
      else if (ans == 2)//choose party member to give HP
      {
         Hero teammate = new Hero();//use World class to select party member or pass in?
         int newTeamHP = teammate.getHP() + 25;//randogen later
         teammate.setHP(newTeamHP);
      }
      else if (ans == 3)
      {
         atk.addDamage(new Damage(25, false, "healing"));//randogen later, make undead class vulnerable to healing damage
      }
      target.takeDamage(atk);*/
   }
   
   @Override
   public String getSpecialName() 
   {
	   return "Special: Heal";
   }
   
   @Override
   public String getSpecialDescription()
   {
	   return "Through divine magic you heal your target.\nIn addition, you will heal a small amount for the next 5 turns.";
   }
   
}//end Cleric