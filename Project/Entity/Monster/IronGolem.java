   package Project.Entity.Monster;

   
   import Project.Entity.Entity;
   import Project.Behavior.Defense.ElementalResistance;
   import Project.Behavior.Defense.DamageReduction;
   import Project.Behavior.Offense.Damage;
   import Project.Behavior.Offense.Attack;
   import java.util.Random;

   public class IronGolem extends Construct {
   
      private boolean isCorroded = false;
   
      public IronGolem() {
    	 setName("Iron Golem"); 
         this.hp = 450;
         this.power = 35;
         this.speed = 5;
      
         this.dodge = 0.0;
         this.accuracy = 0.6;
      
         this.er = new ElementalResistance();
         er.setAcid(0, 2.0);
         er.setFire(0, 0.0);
         er.setCold(0, 0.0);
         er.setElec(0, 1.0);
      
         this.dr = new DamageReduction(15, "adamantine");
         super.setSprite("Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_IRONGOLEM.png");
      
      }//end constructor
   
   
      public void hitBySpecialElement(Damage dmg) {
    	  if(dmg.getDamageType().contains("acid") && !this.isCorroded) {
              this.isCorroded = true;
              this.dr.setReduction(this.dr.getReduction()/2);
              System.out.println("The acid damage corrodes the metal, reducing its physical defense!");
    	  }
      }//end method
   
      public String takeDamage(Attack atk) {
         int actualDamage = 0;
         if(Math.random() <= this.dodge)
         {
        	 return("The golem dodged the attack!");
        	 
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
               result += ("This entity took " + actualDamage + " points of " + dmg.getDamageType() + " damage");
            
            
               if(dmg.getDamageType().contains("acid")) {
                 this.hitBySpecialElement(dmg);
               } //end if
            
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
      atk.addDamage(new Damage(25+rand.nextInt(5), true, "bludgeon"));
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
      Attack atk = new Attack();
      Random rand = new Random();
      atk.addDamage(new Damage(70+rand.nextInt(15), false, "bludgeon,adamantine"));
      atk.applyPower(this.power);
      return target.takeDamage(atk);
	  }
	  else
	  {
		  return ("The attack failed!");
	  }
	  
   }
	
}//end class