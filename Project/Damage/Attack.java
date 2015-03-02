package Project.Damage;

import java.util.ArrayList;
//This class represents a 'package' of damage values from a single attack to be sent to the target.
public class Attack {

private ArrayList<Damage> list;

public Attack() {
   list = new ArrayList<Damage>();
}

public void addDamage(Damage dmg) {
   this.list.add(dmg);
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