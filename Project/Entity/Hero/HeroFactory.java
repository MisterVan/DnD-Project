package Project.Entity.Hero;

import java.util.Scanner;

import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Item.Weapon.Weapon;
//Regular factory
public class HeroFactory
{
   public Hero createHero(String type)
   {
      Hero hero = null;
      String name = askName(type);
      
      if(type.equals("Fighter"))
      {
         hero = new Fighter();
         hero.setPlayerName(name);
      }
      else if (type.equals("Wizard"))
      {
         hero = new Wizard();
         hero.setPlayerName(name);
      }
      else if (type.equals("Barbarian"))
      {
         hero = new Barbarian();
         hero.setPlayerName(name);
      }
      else if (type.equals("Cleric"))
      {
         hero = new Cleric();
         hero.setPlayerName(name);
      }
      else if (type.equals("Monk"))
      {
         //hero = new Monk();
         hero.setPlayerName(name);
      }
      else if (type.equals("Ranger"))
      {
         //hero = new Ranger();
         hero.setPlayerName(name);
      }
      return hero;
   }//end createHero
   
   //asks user to name a hero as it is being created
   public String askName(String type)
   {
      Scanner kb = new Scanner(System.in);
      String ans = null;
      int sure = 2;
      
      while (sure != 1)
      {
         System.out.println("What would you like this " + type + " to be named?");
         ans = kb.nextLine();
         System.out.println("You want your " + type + " to be named " + ans + "?");
         System.out.println("1 - yes");
         System.out.println("2 - no");
         sure = kb.nextInt();
         kb.nextLine();
      }
      System.out.println("Your " + type + " is now named " + ans + ".");
      return ans;
   }//end askName
}