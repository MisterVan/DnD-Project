package Project.World;

public class WaterTile extends Tile {

	public WaterTile (int x, int y) {
		
		this.setImage("\\Project\\World\\water.png"); // will have to change when redesigning directory structure
		this.setType("Water"); //Possibly useless?
		this.setWalkable(false);
		this.setResident(null); // rock object? (as mock object) .... other space filler to accounnt for collisions? Could make isWalkable redundent
		this.setXCoord(x);
		this.setYCoord(y);		
		
	}//EVC
	
}//WaterTile