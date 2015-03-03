package Project.Entity.Hero;

import java.util.ArrayList;

import Project.Behavior.Offense.Damage;
import Project.Behavior.Offense.Attack;
import Project.Item.Weapon.Weapon;
import Project.Entity.Entity;

public class Hero extends Entity
{
   private Weapon primaryWpn;
   private Weapon secondaryWpn;
   private String playerName = "Unknown";
   //private ArrayList<Item> items;
   
   //primary attack
   public Attack primaryAttack()
   {
      return primaryWpn.attack();
   }
   
   //secondary attack
   public Attack secondaryAttack()
   {
      return secondaryWpn.attack();
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
   
   public void setSecondaryWpn(Weapon newWpn)
   {
      this.secondaryWpn = newWpn;
   }
   
   public Weapon getSecondaryWpn()
   {
      return this.secondaryWpn;
   }
   
}//end Hero