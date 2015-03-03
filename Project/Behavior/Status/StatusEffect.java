package Project.Behavior.Status;
//Note: Although it does not involve java's interfaces, the relationship between a status effect
//and an entity is that of the Observer pattern. Whenever an entity's turn comes up, all status 
//effects are notified so that they can deal damage or reapply certain effects.

import Project.Entity.Entity;

public interface StatusEffect {

public void applyEffectToTarget(Entity target); //The initial application of the status effect.
public void reapplyEffectToTarget(); //This gets called each turn to reapply the effect or deal more damage.
public void removeEffectFromTarget();
public void resetDuration(); //If a status effect is already on an entity, it's duration should be reset instead of having two instances of the status.
public boolean isBeneficial(); //Some abilities must remove all bad status effects, so this method is necessary to know which ones to keep.
public String getName(); //Allows us to see if an entity already has a certain buff, and helps with identifying damage source on output.
public int getCounter();


//That is, same status effects should never stack.

}