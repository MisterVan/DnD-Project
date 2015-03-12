package Project.World;

import javafx.scene.image.Image;

public class WaterTile extends Tile {

	public WaterTile (Image image, int x, int y) {
		
		this.setImage(image); // will have to change when redesigning directory structure
		this.setType("Water"); //Possibly useless?
		this.setWalkable(false);
		this.setResident(null); // rock object? (as mock object) .... other space filler to accounnt for collisions? Could make isWalkable redundent
		this.setXCoord(x);
		this.setYCoord(y);		
		
	}//EVC
	
}//WaterTile