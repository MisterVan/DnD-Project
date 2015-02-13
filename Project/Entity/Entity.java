package Project.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;

/*
This class is the superparent for all characters in the game, player or monster.
As parent class, it implements generic behavior for taking taking damage, having status effects, and attacking others
*/


public class Entity {
    
    private String name = "Unknown";
    private int hp;
    private int power;
    private int speed;
    
    private double accuracy;
    private double dodge;
    
    DamageReduction dr;
    ElementalResistance er;
    
    //Trinket item;
   // Consumable potion;
    //Weapon firstWeapon;
    //Weapon secondWeapon;
    
//This object takes damage after applying all relevant resistances, immunities, and damage reduction
public void takeDamage(Attack atk) {
int actualDamage = 0;

for(Damage dmg : atk.getDamage()) {
   if(dmg.isPhysical()) {
    actualDamage = dr.processDamage(dmg);
    this.hp -= actualDamage;
    System.out.println(this.name + " took " + actualDamage + " points of " + dmg.getDamageType() + " damage"); //This print is just used for feedback in testing
   }
   else {//it's magical 
    actualDamage = er.processDamage(dmg);
    this.hp -= actualDamage;
    System.out.println(this.name + " took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
   }
   }
}//end method


public void setName(String newName)
{
   this.name = newName;
}

public String getName()
{
   return this.name;
}

public int getPower() {
   return this.power;
}

public int getHP()
{
   return this.hp;
}

public void setPower(int p) {
   this.power = p;
}

public void setHP(int hp) {
   this.hp = hp;
}
 
public void setSpeed(int s) {
   this.speed = s;
}     

public void setAccuracy(double a) {
   this.accuracy = a;
}

public void setDodge(double d) {
   this.dodge = d;
}

public void setDamageReduction(DamageReduction dr) {
   this.dr = dr;
}

public void setElementalResistance(ElementalResistance er) { 
   this.er = er;
}

//Gives the player a status effect, whether a buff or a detrimental effect.
/*
public void giveStatus(Status stat) {
    
}

*/

}//end class