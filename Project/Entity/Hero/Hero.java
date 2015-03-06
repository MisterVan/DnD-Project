package Project.Entity.Hero;

import java.util.Scanner;
import java.util.ArrayList;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Item.Item;
import Project.Entity.Entity;

public class Hero extends Entity
{
   private Weapon primaryWpn;
   private String playerName = "Unknown";
   protected ArrayList<Item> inventory;
   
   //primary attack
   public Attack primaryAttack()
   {
      if(primaryWpn == null)
      {
         System.out.println("Error: no weapon equipped!");
      }
      return primaryWpn.attack();
   }
   
   /* 
   //secondary attack (Not needed, can choose to carry two or three weapons and switch out primary)
   public Attack secondaryAttack()
   {
      return secondaryWpn.attack();
   }
   */
   
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
   
   public void pickUp(Item newItem)
   {
      /*
      if (newItem instanceof Weapon)
      {
         //Menu asking if they want to equip the weapon as primary
         //If yes, do they want to drop their current weapon or add it to inventory?
      }
      */
   }
   
   public void addToInventory (int index, Item newItem)
   {
      if (this.inventory.size() >= 2)
      {
         System.out.println("Inventory Full: You must drop an item!");
         dropInventoryItem();
      }
      else
      {
         this.inventory.add(index, newItem);
      }
   }
   
   //possibly refactor into more methods, or get rid of menu with gui
   //What if they want to drop their primary weapon to pick up a new one, but hold no other weapons to switch to temporarily. Must automatically equip whatever weapon is in inventory (but what if no weapons are held at all?)
   public Item dropInventoryItem()
   {
      Item dropped = null;
      if (this.inventory.isEmpty())
      {
         System.out.println("Inventory is empty!");
      }
      else
      {
         int ans = -1;//user choice
         while((ans < 0) || (ans > 2))
         {
            System.out.println("Which item would you like to drop?");
            if (this.inventory.get(0) != null)
            {
               System.out.println("1 - " + this.inventory.get(0).getName());
            }
            if (this.inventory.get(1) != null)
            {
               System.out.println("2 - " + this.inventory.get(1).getName());
            }
            /*
            if (this.primaryWpn != null)
            {
               System.out.println("3 - " + this.primaryWpn.description()); //should this be able to be null?
            }
            */
            
            System.out.println("0 - None");
            Scanner kb = new Scanner(System.in);
            ans = kb.nextInt();
            kb.nextLine();
            
            if ((ans != 0) || (ans != 1) || (ans != 2))//not in range
            {
               System.out.println("Error: please pick a valid inventory slot!");
            }
         }
         if (ans == 0)
         {
            System.out.println("No items have been dropped.");
         }
         else if (ans == 1)
         {
            dropped = this.inventory.get(0);
            this.inventory.remove(dropped);//remove first inventory item
            return dropped;
         }
         else if (ans == 2)
         {
            dropped = this.inventory.get(1);
            this.inventory.remove(dropped);//remove second inventory item
         }
      }
      return dropped;
   }
   
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
   
   /*
   public void setSecondaryWpn(Weapon newWpn)
   {
      this.secondaryWpn = newWpn;
   }
   
   public Weapon getSecondaryWpn()
   {
      return this.secondaryWpn;
   }
   */
   
}//end Hero