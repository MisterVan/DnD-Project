package Project.Entity;

import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Behavior.Status.StatusEffect;
import Project.World.MapResident;
import java.util.ArrayList;

/*
This class is the superparent for all characters in the game, player or monster.
As parent class, it implements generic behavior for taking taking damage, having status effects, and attacking others
*/


public abstract class Entity extends MapResident {
    
    //protected String name = "Unknown";
    protected int baseHP;
    protected int hp;
    protected int power;
    protected int speed;
    
    protected double accuracy;
    protected double dodge;
    
    protected DamageReduction dr;
    protected ElementalResistance er;
    
    protected boolean isCritImmune;
    
    ArrayList<StatusEffect> statusEffects = new ArrayList<StatusEffect>();    

public abstract void specialMove(Entity target);
    
//This object takes damage after applying all relevant resistances, immunities, and damage reduction
public void takeDamage(Attack atk)
{
   int actualDamage = 0;
   if(Math.random() <= this.dodge)
   {
	   System.out.println("The " + this.name + " dodged the attack!");
	   return;
   }
   for(Damage dmg : atk.getDamage())
   {
      if(dmg.isPhysical())
      {
         actualDamage = dr.processDamage(dmg);
         this.hp -= actualDamage;
         System.out.println(this.name + " took " + actualDamage + " points of " + dmg.getDamageType() + " damage"); //This print is just used for feedback in testing
      }
   else//it's magical
   { 
      actualDamage = er.processDamage(dmg);
      this.hp -= actualDamage;
      System.out.println(this.name + " took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
   }
  }
   
   if(atk.hasStatus())
      this.giveStatus(atk.deliverStatus());
}//end method

/*
GETS, SETS =======================
*/
/*public void setName(String newName)
{
   this.name = newName;
}

public String getName()
{
   return this.name;
}
*/
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
   this.baseHP = hp;
}
 
public void setSpeed(int s) {
   this.speed = s;
}     

public void setAccuracy(double a) {
   this.accuracy = a;
}

public double getAccuracy() {
	return this.accuracy;
}

public void setDodge(double d) {
   this.dodge = d;
}

public double getDodge() {
   return this.dodge;
}

public void setDamageReduction(DamageReduction dr) {
   this.dr = dr;
}

public DamageReduction getDamageReduction() {
   return this.dr;
}

public void setElementalResistance(ElementalResistance er) { 
   this.er = er;
}

public boolean isDead() {
	return this.hp <= 0;
}   

/*
STATUS EFFECTS
*/

public ArrayList<StatusEffect> getStatusEffects() {
	return this.statusEffects;
}
public void giveStatus(StatusEffect stat) {

   for(StatusEffect e: statusEffects) {
      if(e.getName().equals(stat.getName())) { //If we already have the status
         e.resetDuration();
         return;
         }
   }//end loop

	
   //If we get here, we don't have the status effect already, so we apply it.
    this.statusEffects.add(stat);
	stat.applyEffectToTarget(this);
}

public void recoverHP(int amount) {
   this.hp += amount;
   if(this.hp > this.baseHP)
      this.hp = this.baseHP;
}

public void removeStatus(StatusEffect stat) {
   stat.removeEffectFromTarget();
   this.statusEffects.remove(stat);
}

public void roundOver() { //gets called after the end of every round.
StatusEffect e;

for(int i = 0; i < statusEffects.size(); i++) {
	e = statusEffects.get(i);
	e.reapplyEffectToTarget();
	if(e.getCounter() <= 0)
		removeStatus(e);
}//end loop

}


}//end class