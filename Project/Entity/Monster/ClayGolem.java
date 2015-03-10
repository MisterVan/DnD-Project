package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class ClayGolem extends Construct {

private boolean isBaked = false;

public ClayGolem() {
	this.hp = 800;
	this.power = 50;
	this.speed = 3;
	
	this.dodge = 0.0;
	this.accuracy = 0.6;
	
	this.er = new ElementalResistance();
	er.setAcid(0, 0.0);
	er.setFire(0, 0.2);
	er.setCold(30, 1.0);
	er.setElec(30, 1.0);
	
	this.dr = new DamageReduction(20, "adamantine,bludgeon");
   //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Hero\\CHARACTER_MONSTER_CLAYGOLEM.png");

}//end constructor

//Clay golems heal by taking acid damage
protected void hitBySpecialElement(Damage dmg) {
if(dmg.getDamageType().contains("acid")) {
	int healthRestored = dmg.getDamage()/2;
	this.hp += healthRestored;
	System.out.println("The acid damage enhances the golem's composition! The Clay Golem recovered " + healthRestored + " hp.");
}
}//end method



public void takeDamage(Attack atk) {
int actualDamage = 0;

for(Damage dmg : atk.getDamage()) {
   if(dmg.isPhysical()) {
    actualDamage = dr.processDamage(dmg);
    this.hp -= actualDamage;
    System.out.println("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage"); //This print is just used for feedback in testing
   }
   else {//it's magical 
	 
	 if(dmg.getDamageType().contains("acid")) { //If it's acid, it heals the golem
	 	this.hitBySpecialElement(dmg);
	 }
	 else { //If its not acid, we take damage
    actualDamage = er.processDamage(dmg);
    this.hp -= actualDamage;
    System.out.println("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
	 }
	 
	 if(dmg.getDamageType().contains("fire") && !this.isBaked) {
	 	this.isBaked = true;
		this.dr.setReduction(this.dr.getReduction()*2);
		System.out.println("The fire damage baked the clay, increasing its physical defense!");
	 } //end if
	 
   } //end else 
	
   }//end for loop

}//end method

/*
TO DO: Attack methods, make sure one attack has chance to give player a curse making them immune to healing.
*/

   @Override
   public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(25, true, "slash"));
      atk.addDamage(new Damage(30, true, "bludgeon"));
      return atk;
	}//end method
   
   @Override
   public Attack specialMove()
   {
      Attack atk = new Attack();
      atk.addDamage(new Damage(35, false, "cold"));
      atk.addDamage(new Damage(30, true, "bludgeon"));
      return atk;
   }

}//end class