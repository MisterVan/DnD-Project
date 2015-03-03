   package Project.Entity.Construct;

   import Project.Entity.Entity;
   import Project.Damage.Damage;
   import Project.Damage.ElementalResistance;
   import Project.Damage.DamageReduction;
   import Project.Damage.Attack;

   public class IronGolem extends Construct {
   
      private boolean isCorroded = false;
   
      public IronGolem() {
      
         this.hp = 1000;
         this.power = 70;
         this.speed = 5;
      
         this.dodge = 0.0;
         this.accuracy = 0.6;
      
         this.er = new ElementalResistance();
         er.setAcid(0, 2.0);
         er.setFire(0, 0.0);
         er.setCold(0, 0.0);
         er.setElec(0, 1.0);
      
         this.dr = new DamageReduction(15, "adamantine");
      
      }//end constructor
   
   
      public void hitBySpecialElement(Damage dmg) {
         if(dmg.getDamageType().contains("electric")) {
         //TO DO: AFFLICT WITH SLOW EFFECT
            System.out.println("The electricity magnetizes the golem, slowing it down!");
         }//end if
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
               actualDamage = er.processDamage(dmg);
               this.hp -= actualDamage;
               System.out.println("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
            
               if(dmg.getDamageType().contains("electric")) { //If it's elec, it slows the golem
                  this.hitBySpecialElement(dmg);
               }//end if
            
               if(dmg.getDamageType().contains("acid") && !this.isCorroded) {
                  this.isCorroded = true;
                  this.dr.setReduction(this.dr.getReduction()/2);
                  System.out.println("The acid damage corrodes the metal, reducing its physical defense!");
               } //end if
            
            } //end else 
         
         }//end for loop
      }//end method
   
	/*
	TO DO: ADD ATTACKS
	 */
	
   }//end class