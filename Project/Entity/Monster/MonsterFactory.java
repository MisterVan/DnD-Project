package Project.Entity.Monster;
import java.util.Random;
import java.util.Scanner;
import java.io.*;



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
         monster = new Basilisk();
         monster.setMonsterName(name);
      }
      else if (type.equals("Chimera"))
      {
         monster = new Chimera();
         monster.setMonsterName(name);
      }
      else if (type.equals("Chimera Skeleton"))
      {
         monster = new ChimeraSkeleton();
         monster.setMonsterName(name);
      }
      else if (type.equals("Gargoyle"))
      {
         monster = new Gargoyle();
         monster.setMonsterName(name);
      }
      else if (type.equals("Gorgon"))
      {
         monster = new Gorgon();
         monster.setMonsterName(name);
      }
      else if (type.equals("Gryphon"))
      {
         monster = new Gryphon();
         monster.setMonsterName(name);
      }
      else if (type.equals("Hydra"))
      {
         monster = new Hydra();
         monster.setMonsterName(name);
      }
      else if (type.equals("Lich"))
      {
         monster = new Lich();
         monster.setMonsterName(name);
      }
      else if (type.equals("Mummy"))
      {
         monster = new Mummy();
         monster.setMonsterName(name);
      }
      else if (type.equals("Skeleton"))
      {
         monster = new Skeleton();
         monster.setMonsterName(name);
      }
      else if (type.equals("Vampire"))
      {
         monster = new Vampire();
         monster.setMonsterName(name);
      }
      else if (type.equals("Worg"))
      {
         monster = new Worg();
         monster.setMonsterName(name);
      }
      else if (type.equals("Wraith"))
      {
         monster = new Wraith();
         monster.setMonsterName(name);
      }
      else if (type.equals("Zombie"))
      {
         monster = new Zombie();
         monster.setMonsterName(name);
      }
      return monster;
   }//end createHero
   
   public Monster createRandomMonster()
   {
	   Monster m = null;
	   String name = assignName();
	   Random rand = new Random();
	   int result = rand.nextInt(17);
	   switch(result)
	   {
	   case 0:
		   m = new Basilisk();
		   m.setName(name);
		   break;
	   case 1:
		   m = new Chimera();
		   m.setName(name);
		   break;
	   case 2:
		   m = new ChimeraSkeleton();
		   m.setName(name);
		   break;
	   case 3:
		   m = new ClayGolem();
		   m.setName(name);
		   break;
	   case 4:
		   m = new FleshGolem();
		   m.setName(name);
		   break;
	   case 5:
		   m = new Gargoyle();
		   m.setName(name);
		   break;
	   case 6:
		   m = new Gorgon();
		   m.setName(name);
		   break;
	   case 7:
		   m = new Gryphon();
		   m.setName(name);
		   break;
	   case 8:
		   m = new Hydra();
		   m.setName(name);
		   break;
	   case 9: 
		   m = new IronGolem();
		   m.setName(name);
		   break;
	   case 10:
		   m = new Lich();
		   m.setName(name);
		   break;
	   case 11:
		   m = new Mummy();
		   m.setName(name);
		   break;
	   case 12:
		   m = new Skeleton();
		   m.setName(name);
		   break;
	   case 13:
		   m = new Vampire();
		   m.setName(name);
		   break;
	   case 14:
		   m = new Worg();
		   m.setName(name);
		   break;
	   case 15:
		   m = new Wraith();
		   m.setName(name);
		   break;
	   case 16:
		   m = new Zombie();
		   m.setName(name);
		   break;
	   }
	   
	   return m;
   }
   //Goes through a text file of predetermined monster names and assigns one to the current monster randomly
   public String assignName()
   {
      String name = null;
      Random rand = new Random();
      int place = rand.nextInt(22);//random int between 0 and 21
      
      try
      {
         Scanner sc = new Scanner(new File("Project\\Entity\\Monster\\monsternames.txt"));
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