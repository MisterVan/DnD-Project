package Project.World;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile {
	
	private ImageView image;
	private boolean isWalkable;
	private MapResident resident;
	private int xCoord;  
	private int yCoord;  
	private ImageView highlight;
	
	public Tile(Image image, int xCoord, int yCoord, Image highlight, boolean walkable) {
		this.image = new ImageView (image);
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.highlight = new ImageView(highlight);
		this.isWalkable = walkable;
	}//EVC
	
	/*
	GETS, SETS =======================
	*/
	public ImageView getHighlight() {
		
		return this.highlight;
	}//getHighlight
	
	public ImageView getImage() {
		
		return this.image;
	}//getImage
	
	public boolean getWalkable() {
		
		return this.isWalkable;
	}//getWalk
	
	public MapResident getResident () {
		
		return this.resident;
	}//getRes
		
	public int getXCoord () {

		return this.xCoord;
	}//getXCoor
	
	public int getYCoord () {

		return this.yCoord;
	}//getYCoor
	
	public void setWalkable (boolean walk) {
		
		this.isWalkable = walk;
	}//setWalkable boolean
	
	public void setResident (MapResident res) {
		
		this.resident = res;
	}//setResidonte MapResident
	
	public void setXCoord (int x) {
		
		this.xCoord = x;
	}//setX int
	
	public void setYCoord (int y) {
		
		this.yCoord = y;
	}//setY int
	
}//class
