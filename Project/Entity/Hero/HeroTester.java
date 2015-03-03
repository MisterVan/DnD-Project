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
      Entity hero1 = heroFac.createHero("Fighter");
      Entity hero2 = heroFac.createHero("Wizard");
      Entity hero3 = heroFac.createHero("Barbarian");
      Entity hero4 = heroFac.createHero("Cleric");
      
      
   }
   
}