package Project.Entity.Monster;


public abstract class Undead extends Monster {

	@Override
	public void recoverHP(int amount)
	{
		if(amount > this.hp)
		{
			int oldHP = this.hp;
			this.hp = 0;
			System.out.println("The " + super.name + " took " + oldHP + " damage!" );
		}
		else
		{
			this.hp -= amount;
			System.out.println("The " + super.name + " took " + amount + " damage!" );
		}
	}

}
