package Project.Entity;
import Project.Damage.ElementalResistance;
import Project.Damage.DamageReduction;
import Project.Damage.Attack;
import Project.Damage.Damage;
import Project.Status.StatusEffect;
import java.util.ArrayList;

/*
This class is the superparent for all characters in the game, player or monster.
As parent class, it implements generic behavior for taking taking damage, having status effects, and attacking others
*/


public class Entity {
    
    protected int hp;
    protected int power;
    protected int speed;
    
    protected double accuracy;
    protected double dodge;
    
    protected DamageReduction dr;
    protected ElementalResistance er;
    
    protected boolean isCritImmune;
    
    ArrayList<StatusEffect> statusEffects;
    
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
    System.out.println("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage"); //This print is just used for feedback in testing
   }
   else {//it's magical 
    actualDamage = er.processDamage(dmg);
    this.hp -= actualDamage;
    System.out.println("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
   }
   }
}//end method

public boolean isDead() {
	return this.hp <= 0;
}


/*
GETS AND SETS ==============================================================
*/
public int getPower() {
   return this.power;
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

public double getDodge() {
   return this.dodge;
}

public void setDodge(double d) {
   this.dodge = d;
}

public DamageReduction getDamageReduction() {
   return this.dr;
}
public void setDamageReduction(DamageReduction dr) {
   this.dr = dr;
}

public void setElementalResistance(ElementalResistance er) { 
   this.er = er;
}

//Gives the player a status effect, whether a buff or a detrimental effect.

public void giveStatus(StatusEffect stat) {
   
   for(StatusEffect e: statusEffects) {
      if(e.getName().equals(stat.getName())) { //If we already have the status
         e.resetDuration();
         return;
         }
   }//end loop
   //If we get here, we don't have the status effect already, so we apply it.
    this.statusEffects.add(stat);
}

public void removeStatus(StatusEffect stat) {
   stat.removeEffectFromTarget();
   this.statusEffects.remove(stat);
}



}//end class