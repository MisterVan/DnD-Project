package Project.Entity.Hero;

import java.util.Scanner;
import java.util.ArrayList;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Item.Item;
import Project.Entity.Entity;

public abstract class Hero extends Entity
{
   protected Weapon primaryWpn;
   private String playerName = "Unknown";
   protected ArrayList<Item> inventory = new ArrayList<Item>();
   
   //primary attack
   public String performAttack(Entity target)
   {
      if(primaryWpn == null)
      {
         System.out.println("Error: no weapon equipped!");
      }
      Attack atk = primaryWpn.attack();
      atk.applyPower(super.power);
      return target.takeDamage(atk);

   }
   
   
   
   //Returns weapon object to either drop back on map or add to inventory to save for later
   public Weapon equipWeapon(Weapon newWeapon)
   {
      Scanner kb = new Scanner(System.in);
      String ans = null;
      Weapon oldWpn = null;
      while ((!ans.toLowerCase().equals("yes")) || (!ans.toLowerCase().equals("no")))
      {
         System.out.println("Do you want to replace " + this.primaryWpn.description() + " with " + newWeapon.description() + "? (yes/no)");
         ans = kb.nextLine();
         if ((!ans.toLowerCase().equals("yes")) || (!ans.toLowerCase().equals("no")))
         {
            System.out.println("Error: invalid input");
         }
      }
      if (ans.toLowerCase().equals("no"))
      {
         System.out.println("Weapon was not equipped.");
         return newWeapon;
      }
      else if (ans.toLowerCase().equals("yes"))
      {
         oldWpn = this.primaryWpn;
         this.primaryWpn = newWeapon;
         System.out.println(oldWpn.description() + " was replaced with " + this.primaryWpn.description() + ".");
         System.out.println(this.primaryWpn.description() + " is currently equipped.");
      }
      return oldWpn;
   }
   
   public void addToInventory (Item newItem)
   {
      if (inventory.size() >= 3)
      {
         Item temp = inventory.get(0);
         temp.drop();
         inventory.remove(0);
      }
      newItem.pickUp(this);
      inventory.add(newItem);
      
   }//end method
   
   
   public void setPlayerName(String newName)
   {
      this.playerName = newName;
   }
   
   public String getPlayerName()
   {
      return this.playerName;
   }
   
   public void setPrimaryWpn(Weapon newWpn)
   {
      this.primaryWpn = newWpn;
   }
   
   public Weapon getPrimaryWpn()
   {
      return this.primaryWpn;
   }
   
   public abstract String getSpecialName();
   public abstract String getSpecialDescription();
   
}//end Hero