package Project.World;

import javafx.scene.image.Image;

public class RockTile extends Tile {

	public RockTile (Image image, int x, int y) {
		
		this.setImage(image); // will have to change when redesigning directory structure
		this.setType("Rock"); //Possibly useless?
		this.setWalkable(false);
		this.setResident(null); // rock object? (as mock object) .... other space filler to accounnt for collisions? Could make isWalkable redundent
		this.setXCoord(x);
		this.setYCoord(y);		
		
	}//EVC
	
}//RockTile
