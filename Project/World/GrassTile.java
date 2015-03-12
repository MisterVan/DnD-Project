package Project.World;

import javafx.scene.image.Image;

public class GrassTile extends Tile {

	public GrassTile (Image image, int x, int y) {
		
		this.setImage(image); // will have to change when redesigning directory structure
		this.setType("Grass"); //Possibly useless?
		this.setWalkable(true);
		this.setResident(null); // rock object? (as mock object) .... other space filler to account for collisions? Could make isWalkable redundant
		this.setXCoord(x);
		this.setYCoord(y);		
		
	}//EVC
	
}//GrassTile