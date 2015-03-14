package Project.Item.Weapon;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class WeaponFactory {


public Weapon createWeapon(String name, String metal, String prefix, String suffix) {
   Weapon w;
   File f = new File(System.getProperty("user.dir") + "\\Project\\Item\\Weapon\\weapons.txt");
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


//Returns a random weapon for the purpose of adding loot onto the map.
public Weapon createRandomWeapon() {
   Random rand = new Random();
   int typeResult, prefixResult, suffixResult, metalResult;
   
   Weapon w = null;
   try{
   int lines = countLines();
   typeResult = rand.nextInt(lines); //Generates number in the range of the linecount for weapons.txt for total weapon bases
   w = getWeapon(typeResult);
   }
   catch(FileNotFoundException e){
   System.out.println("FILE NOT FOUND: " + e);
   System.exit(-1);
   }//end catch
   catch(IOException o) {
   System.out.println("ERROR IN FILE: " + o);
   System.exit(-1);
   }//end catch
   
   metalResult = rand.nextInt(6); // 0-5, we have 3 metal types but also want a greater chance for it to have a regular property
   
   switch(metalResult) {
   case 0:
      w = new WeaponMetalAdamantine(w);
      break;
   case 1:
      w = new WeaponMetalSilver(w);
      break;
   case 2:
      w = new WeaponMetalMetalline(w);
   } //The rest of results do nothing
   
   prefixResult = rand.nextInt(16); //0-15, 50% chance there will be no prefix
   switch(prefixResult) {
   case 0:
      w = new WeaponEffectFlaming(w);
      break;
   case 1:
      w = new WeaponEffectFrost(w);
      break;
   case 2:
      w = new WeaponEffectCorrosive(w);
      break;
   case 3:
      w = new WeaponEffectShocking(w);
      break;
   case 4:
      w = new WeaponEffectDestructive(w);
      break;
   case 5:
      w = new WeaponEffectLacerating(w);
      break;
   case 6:
      w = new WeaponEffectPuncturing(w);
      break;
   case 7:
      w = new WeaponEffectShattering(w);
   }//rest of numbers do nothing
   
   suffixResult = rand.nextInt(10);
   switch(suffixResult) {
   case 0:
      w = new WeaponEffectInferno(w);
      break;
   case 1:
      w = new WeaponEffectBlizzard(w);
      break;
   case 2:
      w = new WeaponEffectStorm(w);
      break;
   case 3:
      w = new WeaponEffectBlackDragon(w);
      break;
   case 4:
      w = new WeaponEffectWrath(w);
   }
   
   return w;
}

//Grabs and returns a weapon at the line number of index in weapons.txt
private Weapon getWeapon(int index) throws IOException, FileNotFoundException{

   Weapon w = null;
   String splitLine[] = null;
   FileReader f = new FileReader(System.getProperty("user.dir") + "\\Project\\Item\\Weapon\\weapons.txt"); //UPDATE THIS WHEN DIRECTORY CHANGES
   BufferedReader fin = null;
   fin = new BufferedReader(f);
   int counter = 0;
   
   while(counter < index){
      fin.readLine(); //parse down file
      counter++;

   }//end loop
   
   String line = fin.readLine();
   splitLine = line.split(" "); 
         
   w = new Weapon(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
   fin.close();
   return w;
}

//Counts number of lines in waepons.txt in case stuff gets added later
private int countLines() throws IOException, FileNotFoundException {
   FileReader f = new FileReader(System.getProperty("user.dir") + "\\Project\\Item\\Weapon\\weapons.txt"); //UPDATE THIS WHEN DIRECTORY CHANGES
   BufferedReader fin = null;

   fin = new BufferedReader(f);
   
   int lines = 0;
   while(fin.readLine() != null) lines++;
   fin.close();
   return lines;
}

private Weapon parseWeaponFile(String name, Scanner fin) {

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