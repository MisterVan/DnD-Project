   package Project.Entity.Monster;

   import Project.Entity.Entity;
   import Project.Behavior.Defense.ElementalResistance;
   import Project.Behavior.Defense.DamageReduction;
   import Project.Behavior.Offense.Damage;
   import Project.Behavior.Offense.Attack;
   import java.util.Random;

   public class FleshGolem extends Construct {
   
      public FleshGolem() {
    	 setName("Flesh Golem"); 
         this.hp = 400;
         this.power = 90;
         this.speed = 4;
      
         this.dodge = 0.1;
         this.accuracy = 0.4;
      
         this.er = new ElementalResistance();
         er.setAcid(0, 0.5);
         er.setFire(0, 0.5);
         er.setCold(0, 0.5);
         er.setElec(0, 0.0);
      
         this.dr = new DamageReduction(8, "adamantine");
         super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_FLESHGOLEM.png");
         
      }//end constructor
		
	public void hitBySpecialElement(Damage dmg) {
         if(dmg.getDamageType().contains("electric")) {
				int healthRestored = dmg.getDamage()/2;
				this.recoverHP(healthRestored);
            System.out.println("The electricity energizes the golem! The Flesh Golem recovers " + healthRestored + " hp.");
         }//end if
   }//end method
	
	public String takeDamage(Attack atk) {
         int actualDamage = 0;
			
			if(Math.random() <= this.dodge) {

				return "The flesh golem avoided the attack!";

			}
		 String result = "";
         for(Damage dmg : atk.getDamage()) {
            if(dmg.isPhysical()) {
               actualDamage = dr.processDamage(dmg);
               this.hp -= actualDamage;
               result += ("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage"); //This print is just used for feedback in testing
            }
            else {//it's magical 
               actualDamage = er.processDamage(dmg);
               this.hp -= actualDamage;
               result = ("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
            
               if(dmg.getDamageType().contains("electric")) { //If it's elec, it slows the golem
                  this.hitBySpecialElement(dmg);
               }//end if
            
            } //end else 
         
         }//end for loop
         
   if(atk.hasStatus())
      this.giveStatus(atk.deliverStatus()); 
   return result;
   }//end method
   

   @Override
   public String performAttack(Entity target)
	{
	  if(Math.random() <= this.accuracy)
	  {
	  Random rand = new Random(); 
      Attack atk = new Attack();
      atk.addDamage(new Damage(25 + rand.nextInt(10), true, "slash"));
      atk.addDamage(new Damage(30 + rand.nextInt(20), true, "bludgeon"));
      atk.applyPower(this.power);

      return target.takeDamage(atk);
	  }
	  else
	  {
		  return ("The attack failed!");

	  }
	}//end method
   
   @Override
   public String specialMove(Entity target)
   {
	  if(Math.random() <= this.accuracy-0.2) 
	  {
	  Random rand = new Random(); 
      Attack atk = new Attack();
      atk.addDamage(new Damage(40+rand.nextInt(41), true, "bludgeon"));
      atk.applyPower(this.power*2);

      return target.takeDamage(atk);
	  }
	  else
	  {
		  return ("The attack failed!");

	  }
   }
}//end class