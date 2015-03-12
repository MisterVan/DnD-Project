package Project.Entity.Monster;

import java.util.ArrayList;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Entity.Entity;

public abstract class Monster extends Entity
{
   private String monsterName = "Unknown";
   //private ArrayList<Item> items;
   
   //primary attack
   public abstract void performAttack(Entity target);
   
   //specialMove
   public abstract void specialMove(Entity target);
   
   public void setMonsterName(String newName)
   {
      this.monsterName = newName;
   }
   
   public String getMonsterName()
   {
      return this.monsterName;
   }
   
}//end Hero