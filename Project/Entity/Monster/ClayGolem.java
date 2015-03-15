package Project.Entity.Monster;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import java.util.Random;

public class ClayGolem extends Construct {

private boolean isBaked = false;

public ClayGolem() {
	setName("Clay Golem");
	this.hp = 300;
	this.power = 40;
	this.speed = 2;
	
	this.dodge = 0.0;
	this.accuracy = 0.6;
	
	this.er = new ElementalResistance();
	er.setAcid(0, 0.0);
	er.setFire(0, 0.2);
	er.setCold(30, 1.0);
	er.setElec(30, 1.0);
	
	this.dr = new DamageReduction(20, "adamantine,bludgeon");
   //super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_CLAYGOLEM.png");

}//end constructor

//Clay golems heal by taking acid damage
protected void hitBySpecialElement(Damage dmg) {
if(dmg.getDamageType().contains("acid")) {
	int healthRestored = dmg.getDamage()/2;
	this.recoverHP(healthRestored);
	System.out.println("The acid damage enhances the golem's composition! The Clay Golem recovered " + healthRestored + " hp.");
}
}//end method



public void takeDamage(Attack atk) {
	int actualDamage = 0;
	if(Math.random() <= this.dodge)
	{
		System.out.println("The clay golem dodged the attack!");
		return;	
	}
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
	
	   if(atk.hasStatus())
	      this.giveStatus(atk.deliverStatus()); 
}//end method


   @Override
   public void performAttack(Entity target)
	{
	  if(Math.random() <= this.accuracy)
	  {
		  Random rand = new Random();
	      Attack atk = new Attack();
	      atk.addDamage(new Damage(35 + rand.nextInt(20), true, "bludgeon"));
	      atk.applyPower(this.power);
	      target.takeDamage(atk);
	  }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
	}//end method
   
   @Override
   public void specialMove(Entity target)
   {
	  if(Math.random() <= (this.accuracy-0.2))
	  {
	  Random rand = new Random(); 
      Attack atk = new Attack();
      atk.addDamage(new Damage(40 + rand.nextInt(25), true, "bludgeon"));
      atk.addDamage(new Damage(20 + rand.nextInt(10), false, "acid"));
      target.takeDamage(atk);
	  }
	  else
	  {
		  System.out.println("The attack failed!");
	  }
   }

}//end class