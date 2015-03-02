package Project.Entity.Hero;

import java.util.Scanner;
import Project.Entity.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;
import Project.Weapon.Weapon;

public class Wizard extends Hero
{
   //Create Wizard
	public Wizard()
	{
		setName("Wizard");
      setHP(170);
		setPower(10);
      setSpeed(50);
      setAccuracy(0.6);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(12, "acid"));//magically vulnerable to poison/acid
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 0.9);
      elRes.setFire(0, 0.9);
      elRes.setAcid(0, 0.9);
      elRes.setElec(0, 0.9);//takes %10 less of all magical damage
      setElementalResistance(elRes);
      Weapon staff = new Weapon("Elemental Staff", "fire,cold,electric", 30, 45);//how decorate tho
      setPrimaryWpn(staff);
      Weapon dagger = new Weapon("Dagger", "slash,pierce", 20, 25);
      setSecondaryWpn(dagger);//Wizard relies on spells
	}//end method
   
   public Attack specialMove()
   {
      //Wizard able to have more specific/powerful spells? idk
      Scanner kb = new Scanner(System.in);
      int ans = 0;
      
      while ((ans != 1)&&(ans != 2)&&(ans != 3)&&(ans != 4))
      {
         System.out.println("Wizard: \n1 - Ice Storm \n2 - Flames \n3 - Lightning Strike \n4 - Acid Splash \n");
         ans = kb.nextInt();
      }
      
      Attack atk = new Attack();
      if (ans == 1)
      {
         atk.addDamage(new Damage(25, false, "cold"));//randogen later
      }
      else if (ans == 2)
      {
         atk.addDamage(new Damage(25, false, "fire"));//randogen later
      }
      else if (ans == 3)
      {
         atk.addDamage(new Damage(25, false, "electric"));//randogen later
      }
      else if (ans == 4)
      {
         atk.addDamage(new Damage(25, false, "acid"));//randogen later
      }
      return atk;
   }
   
}//end Wizard