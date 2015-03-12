package Project.World;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class MapResident {
	
	protected ImageView sprite;
	protected int xCoord;
	protected int yCoord;
	
	/*
	GETS, SETS =======================
	*/
	public ImageView getSprite() {
		
		return this.sprite;		
	}//getSprite
	
	public int getXCoord () {
		
		return this.xCoord;		
	}//getXCoord
	
	public int getYCoord () {
		
		return this.yCoord;		
	}//getYCoord
	
	public void setSprite (String sprite) {
		
		this.sprite = new ImageView (new Image(sprite));		
	}//setSprite	
	
	public void setXCoord (int coord) {
				
		this.xCoord = coord;
	}//setX
	
	public void setYCoord (int coord) {
		
		this.yCoord = coord;
	}//setY
	
}//class
