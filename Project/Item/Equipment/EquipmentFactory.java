package Project.Item.Equipment;

import java.util.Random;


public class EquipmentFactory {


//Generates a random piece of equipment and returns it
public Equipment createRandomEquipment(){
Random rand = new Random();

int result = rand.nextInt(4); //Can generate 0,1,2,or 3
Equipment e;

switch(result){
   case 0:
      e = new BerserkerBand();
      break;
   case 1:
      e = new EagleGoggles();
      break;
   case 2:
      e = new WraithCloak();
      break;
   case 3:
      e = new RingOfRegeneration();
      break;
   default:
      e = new BerserkerBand();
      break;
}//end switch

return e;

}

}//end class