package Project.Weapon;

public abstract class WeaponEffect extends Weapon {

protected Weapon w;

public WeaponEffect(Weapon w){
   this.w = w;
}

public WeaponEffect() {
   w = null;
}

}