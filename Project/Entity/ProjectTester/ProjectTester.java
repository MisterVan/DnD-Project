package Project.Entity.ProjectTester;

import Project.Entity.Monster.Chimera;
import Project.Entity.Monster.Basilisk;
import Project.Entity.Monster.Worg;
import Project.Entity.Monster.Gorgon;
import Project.Entity.Monster.Gryphon;
import Project.Entity.Monster.Hydra;
import Project.Entity.Monster.Gargoyle;


import Project.Entity.Entity;
import Project.Behavior.Defense.ElementalResistance;
import Project.Behavior.Defense.DamageReduction;
import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;

public class ProjectTester
{
   
   public static void main(String[] args) {

      Entity e = new Entity();
      e.setHP(200); //200 hp
      e.setPower(30); //30 power
      
      DamageReduction dr = new DamageReduction(10, "bludgeon"); //Damage reduced by 10 unless it is bludgeoning.
      e.setDamageReduction(dr); //Give damage reduction to entity.
      
      ElementalResistance er = new ElementalResistance(); //Default constructor means no immunities or resistances
      er.setCold(0, 0.5); //Takes half cold damage
      er.setFire(0, 2.0); //Takes double fire damage
      e.setElementalResistance(er); //Give resistance to entity.
      
      Attack atk = new Attack();
      atk.addDamage(new Damage(15, true, "slash"));
      atk.addDamage(new Damage(10, true, "bludgeon"));
      atk.addDamage(new Damage(5, false, "fire"));
      atk.addDamage(new Damage(30, false, "cold"));
      
      e.takeDamage(atk); 
      
      //To see in depth how classes interact, go into debug.
      
      
      Attack atk2 = new Attack();
      atk2.addDamage(new Damage(10, true, "slash"));
      atk2.addDamage(new Damage(10, true, "bludgeon"));
      atk2.addDamage(new Damage(10, false, "fire"));
      atk2.addDamage(new Damage(10, false, "cold"));
      atk2.addDamage(new Damage(10, false, "electric"));
      
      //Testing Gargoyle class
      System.out.println("\nGARGOYLE:");
      Entity garg = new Gargoyle();
      System.out.println(garg.getName() + "'s hp is: " + garg.getHP());
      garg.takeDamage(atk2);
      System.out.println(garg.getName() + "'s hp is now: " + garg.getHP());
      
      //Testing Hydra class
      System.out.println("\nHYDRA:");
      Entity hydra = new Hydra();
      System.out.println(hydra.getName() + "'s hp is: " + hydra.getHP());
      hydra.takeDamage(atk2);
      System.out.println(hydra.getName() + "'s hp is now: " + hydra.getHP());
      
      
      //Testing Gryphon class
      System.out.println("\nGRYPHON:");
      Entity gryphon = new Gryphon();
      System.out.println(gryphon.getName() + "'s hp is: " + gryphon.getHP());
      gryphon.takeDamage(atk2);
      System.out.println(gryphon.getName() + "'s hp is now: " + gryphon.getHP());
      
     //Testing Gorgon class
      System.out.println("\nGORGON:");
      Entity gorgon = new Gorgon();
      System.out.println(gorgon.getName() + "'s hp is: " + gorgon.getHP());
      gorgon.takeDamage(atk2);
      System.out.println(gorgon.getName() + "'s hp is now: " + gorgon.getHP());
      
      //Testing Worg class
      System.out.println("\nWORG:");
      Entity worg = new Worg();
      System.out.println(worg.getName() + "'s hp is: " + worg.getHP());
      worg.takeDamage(atk2);
      System.out.println(worg.getName() + "'s hp is now: " + worg.getHP());
      
      //Testing Basilisk class
      System.out.println("\nBASILISK:");
      Entity basilisk = new Basilisk();
      System.out.println(basilisk.getName() + "'s hp is: " + basilisk.getHP());
      basilisk.takeDamage(atk2);
      System.out.println(basilisk.getName() + "'s hp is now: " + basilisk.getHP());
      
      //Testing Chimera class
      System.out.println("\nCHIMERA:");
      Entity chimera = new Chimera();
      System.out.println(chimera.getName() + "'s hp is: " + chimera.getHP());
      chimera.takeDamage(atk2);
      System.out.println(chimera.getName() + "'s hp is now: " + chimera.getHP());
      
   
   }
   
   
}//end ProjectTester