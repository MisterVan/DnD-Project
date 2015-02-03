   package Project.Entity.Construct;

   import Project.Entity.Entity;
   import Project.Damage.Damage;
   import Project.Damage.ElementalResistance;
   import Project.Damage.DamageReduction;
   import Project.Damage.Attack;
	import java.util.Random;

   public class FleshGolem extends Construct {
   
      public FleshGolem() {
      
         this.hp = 1200;
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
         
      }//end constructor
		
	public void hitBySpecialElement(Damage dmg) {
         if(dmg.getDamageType().contains("electric")) {
				int healthRestored = dmg.getDamage()/2;
				this.hp += healthRestored;
            System.out.println("The electricity energizes the golem! The Flesh Golem recovers " + healthRestored + " hp.");
         }//end if
   }//end method
	
	public void takeDamage(Attack atk) {
         int actualDamage = 0;
			Random rand = new Random();
			
			if(rand.nextDouble() <= this.dodge) {
				System.out.println("The flesh golem avoided the attack!");
				return;
			}
      
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
            
               if(dmg.getDamageType().contains("electric")) { //If it's elec, it slows the golem
                  this.hitBySpecialElement(dmg);
               }//end if
            
            } //end else 
         
         }//end for loop
   }//end method
   
   /*
	TO DO: ADD ATTACKS
	*/
   }//end class