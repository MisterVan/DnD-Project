package Project.Entity.Monster;
import java.util.Random;

import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class Hydra extends Monster
{
   Random rand = new Random(); 
   private int numHeads = rand.nextInt(5) + 1; //hydra can start off with 1 to 5 heads
   
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
      //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Hero\\CHARACTER_MONSTER_HYDRA.png");
	}//end method
   
   //Perform attack
	public Attack performAttack()
	{
      Attack atk = new Attack();
      atk.addDamage(new Damage(30, true, "slash")); //mostly slashes/bites
      atk.addDamage(new Damage(5, false, "acid")); //can spit venom that blinds oponent for one round
      atk.addDamage(new Damage(10, false, "cold"));
      return atk;
	}//end method
   
   @Override
   public Attack specialMove()
   {
      //Waits until it takes 20 or more slash damage, indicating a head has been lost.
      //
      //numHeads decreases by 1, accuracy decreases by 0.1, hp decreases by 10(?), and all damage reduction is lost.
      //
      //After two rounds (or more, extra rounds added for every 30 pts fire damage taken), numHeads is increased by 2,
      //hp is increased by 20, accuracy increased by 0.2, and damage reduction is regained.
      return null;
   }
   
}//end Hydra