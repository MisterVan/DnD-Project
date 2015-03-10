package Project.Behavior.Offense;


import java.util.ArrayList;
import Project.Behavior.Status.StatusEffect;
//This class represents a 'package' of damage values from a single attack to be sent to the target.
public class Attack {

private ArrayList<Damage> list;
private StatusEffect status;

public Attack() {
   list = new ArrayList<Damage>();
}

public void addDamage(Damage dmg) {
   this.list.add(dmg);
}

//Be sure to check if this object has a status before trying to call this or else you'll get a null pointer
public StatusEffect deliverStatus() {
	return this.status;
}

public boolean hasStatus() {
	return this.status != null;
}

public void addStatus(StatusEffect s) {
	this.status = s;
}

public ArrayList<Damage> getDamage() {
   return this.list;
}

public void applyPower(int p) {
   if(list.size() > 0)
      {
      Damage dmg = list.get(0);
      dmg.addDamage(p);
      }
}

}//end class