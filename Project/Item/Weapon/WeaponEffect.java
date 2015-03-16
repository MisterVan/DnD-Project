package Project.Item.Weapon;

import javafx.scene.image.ImageView;

public abstract class WeaponEffect extends Weapon {

protected Weapon w;

@Override
public ImageView getSprite(){
	
	return w.getSprite();
}

public WeaponEffect(Weapon w){
   this.w = w;
}

public WeaponEffect() {
   w = null;
}

}