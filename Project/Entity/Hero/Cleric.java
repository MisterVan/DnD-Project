package Project.Entity.Hero;

import java.util.Scanner;
import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;
import Project.Weapon.Weapon;

public class Cleric extends Hero
{
   //Create Cleric
	public Cleric()
	{
		setName("Cleric");
      setHP(200);
		setPower(15);
      setSpeed(50);
      setAccuracy(0.7);
      setDodge(0.4);
      setDamageReduction(new DamageReduction(10, "fire,acid"));
      ElementalResistance elRes = new ElementalResistance();
      elRes.setCold(0, 0.8);
      elRes.setElec(0, 0.9);
      setElementalResistance(elRes);
      Weapon fists = new Weapon("Fists", "bludgeon", 25, 32);
      setPrimaryWpn(fists);
      Weapon dagger = new Weapon("Dagger", "slash,pierce", 20, 25);
      setSecondaryWpn(dagger);//Cleric relies on spells
      
	}//end method
   
   public Attack specialMove()
   {
      //Cleric uses healing spells, applicable towards teammates and monsters (undead take damage from healing/holy spells)
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
         Hero teammate = new Hero();//use World class to select party memeber or pass in?
         int newTeamHP = teammate.getHP() + 25;//randogen later
         teammate.setHP(newTeamHP);
      }
      else if (ans == 3)
      {
         atk.addDamage(new Damage(25, false, "healing"));//randogen later, make undead class vulnerable to healing damage
      }
      return atk;
   }
   
}//end Cleric