package Project.Entity.Hero;

import java.util.Scanner;
import Project.Entity.Entity;

import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Item.Item;
import Project.Item.Equipment.EagleGoggles;

public class Barbarian extends Hero
{
   //Create Barbarian
	public Barbarian()
	{
		setName("Barbarian");
      setHP(200);
		setPower(20);
      setSpeed(50);
      setAccuracy(0.6);
      setDodge(0.2);
      setDamageReduction(new DamageReduction(10, "fire"));//wears fur/is vulnerable to fire
      ElementalResistance elRes = new ElementalResistance();
      elRes.setCold(0, 0.8);
      elRes.setElec(0, 0.9);
      setElementalResistance(elRes);
      Weapon mace = new Weapon("Mace", "bludgeon,slash", 35, 45);
      setPrimaryWpn(mace);
      //This makes like no sense with stomp being a 'weapon'. Consider taking this out and
      //inherently equipping everyone with a dagger to start off with as a secondary?
      Weapon stomp = new Weapon("Stomp", "bludgeon", 20, 25);
      this.inventory.add(0, stomp);
      //super.setSprite(System.getProperty("user.dir") + "\\Project\\Sprites\\Characters\\Hero\\CHARACTER_HERO_BARBARIAN.png");
	}//end method
   
   public Attack specialMove()
   {
      //Barbarian uses stoneskin for a number of rounds(handle status effect) and gives a first initial brute strength attack
      
      Attack rage = new Attack();
      rage.addDamage(new Damage(40, true, "bludgeon"));//randogen later
      rage.addDamage(new Damage(40, true, "slash,pierce"));//randogen later
      return rage;
   }
   
}//end Barbarian