package Project.Entity.Hero;

import Project.Entity.Monster.*;
import Project.Entity.Hero.*;


import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class HeroTester
{
   public static void main(String[] args)
   {
      HeroFactory heroFac = new HeroFactory();
      Hero hero1 = heroFac.createHero("Fighter");
      Hero hero2 = heroFac.createHero("Wizard");
      Hero hero3 = heroFac.createHero("Barbarian");
      Hero hero4 = heroFac.createHero("Cleric");
      
      //TESTING HERO DAMAGE
      Attack atk = new Attack();
      atk.addDamage(new Damage(10, true, "slash"));
      atk.addDamage(new Damage(10, true, "bludgeon"));
      atk.addDamage(new Damage(10, false, "fire"));
      atk.addDamage(new Damage(10, false, "cold"));
      atk.addDamage(new Damage(10, false, "electric"));
      
      //Fighter
      System.out.println("\n" + hero1.getName() + ":");
      System.out.println(hero1.getPlayerName() + "'s hp is: " + hero1.getHP());
      hero1.takeDamage(atk);
      System.out.println(hero1.getPlayerName() + "'s hp is now: " + hero1.getHP());
      
      //Wizard
      System.out.println("\n" + hero2.getName() + ":");
      System.out.println(hero2.getPlayerName() + "'s hp is: " + hero2.getHP());
      hero2.takeDamage(atk);
      System.out.println(hero2.getPlayerName() + "'s hp is now: " + hero2.getHP());
      
      //Barbarian
      System.out.println("\n" + hero3.getName() + ":");
      System.out.println(hero3.getPlayerName() + "'s hp is: " + hero3.getHP());
      hero3.takeDamage(atk);
      System.out.println(hero3.getPlayerName() + "'s hp is now: " + hero3.getHP());
      
      //Cleric
      System.out.println("\n" + hero4.getName() + ":");
      System.out.println(hero4.getPlayerName() + "'s hp is: " + hero4.getHP());
      hero4.takeDamage(atk);
      System.out.println(hero4.getPlayerName() + "'s hp is now: " + hero4.getHP());
   }
   
}