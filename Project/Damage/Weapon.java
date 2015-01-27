//This class represents all weapons in the game.

public class Weapon {


private double critChance;
private int critMultiplier;
private Entity wielder; //A weapon requires a wielder to do anything, if it is null then nothing else should happen

private String damageType;
private String enhancement;
private String name;

private int damageMin;
private int damageMax;



//Called whenever an entity picks up this weapon
public void equip(Entity e) {
   this.wielder = e;
}

//Called whenever the wielder drops or trades this weapon
public void unequip() {
   this.wielder = null;
}

public String description() {
   return this.name;
}

public Attack attack() {
Attack atk = new Attack();

//Calculate damages and add it to atk
return atk;
}

}//end class