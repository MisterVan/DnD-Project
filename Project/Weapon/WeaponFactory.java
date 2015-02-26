package Project.Weapon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeaponFactory {


public Weapon createWeapon(String name, String metal, String prefix, String suffix) {
   Weapon w;
   File f = new File(System.getProperty("user.dir") + "\\Project\\Weapon\\weapons.txt");
   Scanner fin = null;
   try {
   fin = new Scanner(f);
   }
   catch(FileNotFoundException e) {
   System.out.println("FILE NOT FOUND: " + e);
   System.exit(-1);
   }
   w = parseWeaponFile(name, fin);
   
   switch(metal.toLowerCase()) { //Metal type
   case "adamantine":
         w = new WeaponMetalAdamantine(w);
         break;
   case "silver":
         w = new WeaponMetalSilver(w);
         break;
   case "metalline":
         w = new WeaponMetalMetalline(w);
         break;
   default: break;
   }//end switch
   
   
   switch(prefix.toLowerCase()) { //Prefixes
    case "flaming":
         w = new WeaponEffectFlaming(w);
         break;
    case "frost":
         w = new WeaponEffectFrost(w);
         break;
    case "shocking":
         w = new WeaponEffectShocking(w);
         break;
    case "corrosive":
         w = new WeaponEffectCorrosive(w);
         break;
    case "destructive":
         w = new WeaponEffectDestructive(w);
         break;
    case "lacerating":
         w = new WeaponEffectLacerating(w);
         break;
    case "puncturing":
         w = new WeaponEffectPuncturing(w);
         break;
    case "shattering":
         w = new WeaponEffectShattering(w);
         break;
    default: break;
   }//end switch
   
   switch(suffix.toLowerCase()) { //Suffixes
   case "inferno":
         w = new WeaponEffectInferno(w);
         break;
   case "blizzard":
         w = new WeaponEffectBlizzard(w);
         break;
   case "storm":
         w = new WeaponEffectStorm(w);
         break;
   case "blackdragon":
         w = new WeaponEffectBlackDragon(w);
         break;
   case "wrath":
         w = new WeaponEffectWrath(w);
         break;
   default: break;
   }
   
   fin.close();
   return w;
}

public Weapon parseWeaponFile(String name, Scanner fin) {

   while(fin.hasNextLine()){
      String line = fin.nextLine();
      if(line.toLowerCase().contains(name.toLowerCase())) {
         String[] splitLine = line.split(" ");
         return new Weapon(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
      }
   }//end loop
   
   //If we get here, client asked for something we don't have
   return new Weapon("Rusted metal shard", "slash", 1, 1); //Give them something useless by default
}

}//end class