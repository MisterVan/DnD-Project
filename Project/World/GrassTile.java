package Project.World;

public class GrassTile extends Tile {

	public GrassTile (int x, int y) {
		
		this.setImage("\\Project\\World\\TEXTURE_GRASS.png"); // will have to change when redesigning directory structure
		this.setType("Grass"); //Possibly useless?
		this.setWalkable(true);
		this.setResident(null); // rock object? (as mock object) .... other space filler to account for collisions? Could make isWalkable redundant
		this.setXCoord(x);
		this.setYCoord(y);		
		
	}//EVC
	
}//GrassTile