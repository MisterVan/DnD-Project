package Project.Item;

import Project.Item.Weapon.WeaponFactory;
import Project.Item.Equipment.EquipmentFactory;
import Project.Item.Consumable.ConsumableFactory;
import java.util.Random;

public class ItemFactory {


WeaponFactory w = new WeaponFactory();
ConsumableFactory c = new ConsumableFactory();
EquipmentFactory e = new EquipmentFactory();

public Item createRandomItem() {
	Random rand = new Random();
	int result = rand.nextInt(3); //0-2
	
	switch(result) {
		case 0:
			return w.createRandomWeapon();
		case 1:
			return c.createRandomConsumable();
		case 2:
			return e.createRandomEquipment();
		default: return w.createRandomWeapon();
	}//end switch
	
	
}
}//end class