package Project.Item.Consumable;

import Project.Item.Item;
import Project.Entity.Entity;

public abstract class Consumable extends Item {

@Override
public abstract void pickUp(Entity e);

@Override
public abstract void drop();

public abstract void use();
}