package Project.Weapon;


public class WeaponFactoryTester {


public static void main(String[] args) {

WeaponFactory fac = new WeaponFactory();
System.out.println(System.getProperty("user.dir")); //Current working directory by default is the beginning of the package, not the class directory, remember that
Weapon w1 = fac.createWeapon("Halberd", "Silver", "Flaming", "Inferno");
System.out.println(w1.description());
w1 = fac.createWeapon("Banana", "-", "Destructive", "Wrath");
System.out.println(w1.description());
w1 = fac.createWeapon("Spoon", "Adamantine", "Corrosive", "Blizzard");
System.out.println(w1.description());


//TESTING RANDO'S
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description()); 
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description()); 
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description());
System.out.println(fac.createRandomWeapon().description()); 
}//end main
}//end class