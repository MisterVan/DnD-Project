package Project.Weapon;


public class WeaponFactoryTester {


public static void main(String[] args) {

WeaponFactory fac = new WeaponFactory();
System.out.println(System.getProperty("user.dir"));
Weapon w1 = fac.createWeapon("Halberd", "Silver", "Flaming", "Inferno");
System.out.println(w1.description());
w1 = fac.createWeapon("Banana", "-", "Destructive", "Wrath");
System.out.println(w1.description());
w1 = fac.createWeapon("Spoon", "Adamantine", "Corrosive", "Blizzard");
System.out.println(w1.description());
}//end main
}//end class