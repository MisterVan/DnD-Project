package Project.Entity.Monster;

import java.util.ArrayList;
import Project.Damage.Attack;
import Project.Weapon.Weapon;
import Project.Entity.Entity;

public class Monster extends Entity
{
   private Weapon primaryWpn;
   private Weapon secondaryWpn;
   private String monsterName = "Unknown";
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
   
   public void setMonsterName(String newName)
   {
      this.monsterName = newName;
   }
   
   public String getMonsterName()
   {
      return this.monsterName;
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