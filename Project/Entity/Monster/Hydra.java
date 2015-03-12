package Project.Entity.Monster;
import java.util.Random;

import Project.Behavior.Status.Blind;
import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Hydra extends Monster
{
   Random rand = new Random(); 
   private int numHeads = rand.nextInt(5) + 1; //hydra can start off with 1 to 5 heads
   private int slashTally = 0;
   
   //Create Hydra
	public Hydra()
	{
		setName("Hydra");
      setHP(130 + (10*numHeads));//ten extra hit points per head with a base hp of 130
		setPower(30);
      setSpeed(20);
      setAccuracy(0.5 + (0.1 * numHeads));
      setDodge(0.2);
      setDamageReduction(new DamageReduction(15, "cold")); //Vulnerable to cold
      ElementalResistance elRes = new ElementalResistance();      
      elRes.setCold(0, 2.0); //Takes double cold damage
      //elRes.setElec(0, 1.5); //Takes one and a half electric damage
      
      setElementalResistance(elRes);
      super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Monster\\CHARACTER_MONSTER_HYDRA.png");
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, true, "slash")); //mostly slashes/bites
      atk.addDamage(new Damage(10, false, "cold"));
      atk.addDamage(new Damage(5, false, "acid")); //can spit venom that blinds oponent for one round
      Random rand = new Random(); 
      int blindChance = rand.nextInt(5);
      if(blindChance == 3)//small chance for blindness
      {
         Blind blindEffect = new Blind();
         atk.addStatus(blindEffect);
      }
      return atk;
	}//end method
   
   @Override
   public void takeDamage(Attack atk)
   {
      int actualDamage = 0;
   
      for(Damage dmg : atk.getDamage())
      {
         if(dmg.isPhysical())
         {
            actualDamage = dr.processDamage(dmg);
            this.hp -= actualDamage;
            System.out.println(this.name + " took " + actualDamage + " points of " + dmg.getDamageType() + " damage"); //This print is just used for feedback in testing
            if(dmg.getDamageType().contains("slash"))//count slash damage
            {
               this.slashTally = this.slashTally + actualDamage;
            }
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
      
   @Override
   public Attack specialMove()
   {
      //Waits until it takes 30 or more slash damage, indicating a head has been lost.
      //numheads increases by 1, HP increases by 20 indicating the addition of 'two new heads'
      //Hydra is momentarily blinded because of this.
      if(this.slashTally > 30)
      {
         this.numHeads++;
         this.setHP(this.getHP()+20);
         System.out.println("A head of the hydra has been cut off and replaced with two new ones!");
      }
      Blind regrowthEffect = new Blind();
      regrowthEffect.applyEffectToTarget(this);
      
      //also does a weaker attack
      Attack atk = new Attack();
      atk.addDamage(new Damage(10, true, "slash")); //slashes/bites
      atk.addDamage(new Damage(10, false, "cold"));
      atk.addDamage(new Damage(5, false, "acid")); //can spit venom that blinds oponent for one round
      Random rand = new Random(); 
      int blindChance = rand.nextInt(5);
      if(blindChance == 3)//small chance for blindness
      {
         Blind blindEffect = new Blind();
         atk.addStatus(blindEffect);
      }
      return atk;
   }
   
}//end Hydra