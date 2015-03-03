package Project.Entity.ProjectTester;

import Project.Entity.Entity;
import Project.Behavior.Status.*;
import Project.Behavior.Defense.ElementalResistance;


public class StatusTester {

public static void main(String[] args) throws InterruptedException {

Entity poisonEntity = new Entity();
poisonEntity.setName("Poisoned Entity");
poisonEntity.setHP(500);
poisonEntity.setElementalResistance(new ElementalResistance());

Entity blindEntity = new Entity();
blindEntity.setName("Blind Entity");
blindEntity.setHP(500);
blindEntity.setDodge(0.5);
blindEntity.setAccuracy(0.7);
blindEntity.setElementalResistance(new ElementalResistance());

Entity acidEntity = new Entity();
acidEntity.setName("Corroding Entity");
acidEntity.setHP(500);
acidEntity.setElementalResistance(new ElementalResistance());

Entity fireEntity = new Entity();
fireEntity.setName("Burning Entity");
fireEntity.setHP(500);
fireEntity.setElementalResistance(new ElementalResistance());


//GIVE THEM THEIR STATUSES
System.out.println("Before being blinded...");
System.out.println("Blind entity's dodge: " + blindEntity.getDodge() + " accuracy: " + blindEntity.getAccuracy());
blindEntity.giveStatus(new Blind());
System.out.println("After being blinded...");
System.out.println("Blind entity's dodge: " + blindEntity.getDodge() + " accuracy: " + blindEntity.getAccuracy());

poisonEntity.giveStatus(new Poison());

acidEntity.giveStatus(new CorrosiveAcid());
fireEntity.giveStatus(new BurningFlames());


System.out.println("\nBEGIN ROUND TESTING\n");
for(int i = 0; i < 12; i++) {
blindEntity.roundOver();
poisonEntity.roundOver();
System.out.println("Blind entity's dodge: " + blindEntity.getDodge() + " accuracy: " + blindEntity.getAccuracy());
acidEntity.roundOver();
fireEntity.roundOver();
Thread.sleep(1000);
System.out.println("\nRound " + i + " Over\n");
}
}//end main

}//end class