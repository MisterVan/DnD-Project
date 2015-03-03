package Project.Entity.Monster;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Weapon.Weapon;
//Regular factory/
public class MonsterFactory
{
   public Monster createMonster(String type)
   {
      Monster monster = null;
      String name = assignName();
      System.out.println("The " + type + " is named " + name + ".");//display monster name
      
      if(type.equals("Basilisk"))
      {
         //monster = new Basilisk();
         monster.setMonsterName(name);
      }
      else if (type.equals("Chimera"))
      {
         //monster = new Chimera();
         monster.setMonsterName(name);
      }
      else if (type.equals("Chimera Skeleton"))
      {
         //monster = new ChimeraSkeleton();
         monster.setMonsterName(name);
      }
      else if (type.equals("Gargoyle"))
      {
         //monster = new Gargoyle();
         monster.setMonsterName(name);
      }
      else if (type.equals("Gorgon"))
      {
         //monster = new Gorgon();
         monster.setMonsterName(name);
      }
      else if (type.equals("Gryphon"))
      {
         //monster = new Gryphon();
         monster.setMonsterName(name);
      }
      else if (type.equals("Hydra"))
      {
         //monster = new Hydra();
         monster.setMonsterName(name);
      }
      else if (type.equals("Lich"))
      {
         //monster = new Lich();
         monster.setMonsterName(name);
      }
      else if (type.equals("Mummy"))
      {
         //monster = new Mummy();
         monster.setMonsterName(name);
      }
      else if (type.equals("Skeleton"))
      {
         //monster = new Skeleton();
         monster.setMonsterName(name);
      }
      else if (type.equals("Vampire"))
      {
         //monster = new Vampire();
         monster.setMonsterName(name);
      }
      else if (type.equals("Worg"))
      {
         //monster = new Worg();
         monster.setMonsterName(name);
      }
      else if (type.equals("Wraith"))
      {
         //monster = new Wraith();
         monster.setMonsterName(name);
      }
      else if (type.equals("Zombie"))
      {
         //monster = new Zombie();
         monster.setMonsterName(name);
      }
      return monster;
   }//end createHero
   
   //Goes through a text file of predetermined monster names and assigns one to the current monster randomly
   public String assignName()
   {
      String name = null;
      Random rand = new Random();
      int place = rand.nextInt(22);//random int between 0 and 21
      
      try
      {
         Scanner sc = new Scanner(new File("monsternames.txt"));
         while ((sc.hasNextLine()) && (place >= 0))
         {
            name = sc.nextLine();
            place--;
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error: cannot find file");
      }
      
      return name;
   }//end askName
}