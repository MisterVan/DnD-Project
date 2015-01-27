package Project.ProjectTester;

import Project.Entity.Entity;
import Project.Damage.DamageReduction;
import Project.Damage.ElementalResistance;
import Project.Damage.Attack;
import Project.Damage.Damage;

public class ProjectTester {

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

}


}