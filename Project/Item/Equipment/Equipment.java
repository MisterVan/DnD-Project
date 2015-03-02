package Project.Item.Equipment;

import Project.Item.Item;
import Project.Entity.Entity;

public abstract class Equipment extends Item {

@Override
public abstract void pickUp(Entity e);

@Override
public abstract void drop();

public void procEffect() 
{

}

}