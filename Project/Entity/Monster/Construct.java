package Project.Entity.Monster;

import Project.Behavior.Offense.Damage;

public abstract class Construct extends Monster{



protected abstract void hitBySpecialElement(Damage dmg); //Every golem has a favorable reaction to at least one element.

}//end class