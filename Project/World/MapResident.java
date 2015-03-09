package Project.World;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class MapResident {
	
	protected StringProperty sprite;
	protected int xCoord;
	protected int yCoord;
	
	/*
	GETS, SETS =======================
	*/
	public StringProperty getSprite() {
		
		return this.sprite;		
	}//getSprite
	
	public int getXCoord () {
		
		return this.xCoord;		
	}//getXCoord
	
	public int getYCoord () {
		
		return this.yCoord;		
	}//getYCoord
	
	public void setSprite (String sprite) {
		
		this.sprite = new SimpleStringProperty (sprite);		
	}//setSprite	
	
	public void setXCoord (int coord) {
				
		this.xCoord = coord;
	}//setX
	
	public void setYCoord (int coord) {
		
		this.yCoord = coord;
	}//setY
	
}//class
