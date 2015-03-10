package Project.Item.Consumable;

import java.util.Random;

public class ConsumableFactory {


public Consumable createRandomConsumable() {
   Random rand = new Random();
   
   Consumable c;
   
   int result = rand.nextInt(7);
   
   switch(result) {
   case 0:
      c = new PotionOfLife();
      break;
   case 1:
      c = new GreaterPotionOfLife();
      break;
   case 2:
      c = new ElixirOfLife();
      break;
   case 3:
      c = new PotionOfBlur();
      break;
   case 4:
      c = new PotionOfMight();
      break;
   case 5:
      c = new PotionOfStoneskin();
      break;
   case 6:
      c = new Antidote();
   default:
      c = new PotionOfLife();
      break;
   }//end switch
   
   return c;
}

}