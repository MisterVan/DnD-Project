package Project.Entity.Monster;

import java.util.ArrayList;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Entity.Entity;

public class Monster extends Entity
{
   private String monsterName = "Unknown";
   //private ArrayList<Item> items;
   
   //primary attack
   public Attack performAttack()
   {
      return null;
   }
   
   //specialMove
   public Attack specialMove()
   {
      return null;
   }
   
   public void setMonsterName(String newName)
   {
      this.monsterName = newName;
   }
   
   public String getMonsterName()
   {
      return this.monsterName;
   }
   
}//end Hero