package Project.Entity.Monster;


import Project.Entity.Entity;

public abstract class Monster extends Entity
{
   private String monsterName = "Unknown";
   
   //primary attack
   public abstract String performAttack(Entity target);
   
   //specialMove
   public abstract String specialMove(Entity target);
   
   public void setMonsterName(String newName)
   {
      this.monsterName = newName;
   }
   
   public String getMonsterName()
   {
      return this.monsterName;
   }
   
}//end Hero