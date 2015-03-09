package Project.World;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Tile {
	
	private StringProperty image;
	private BooleanProperty isWalkable;
	private MapResident resident;
	private StringProperty type;
	private int xCoord;  //make a location object??
	private int yCoord;  //make a location object??
		
	/*
	GETS, SETS =======================
	*/
	public StringProperty getImage() {
		
		return this.image;
	}//getImage
	
	public BooleanProperty getWalkable() {
		
		return this.isWalkable;
	}//getWalk
	
	public MapResident getResident () {
		
		return this.resident;
	}//getRes
	
	public String getSimpleImage() {
		
		return this.image.getValue();
	}//getSimpleImage
	
	public String getSimpleType() {
		
		return this.type.getValue();
	}//getSimpleType
	
	public String getSuperSimpleType() {
		
		String t = this.type.getValue();
		t = t.substring(0, 1);
		return t;		
	}//getSuperSimpleType
	
	public StringProperty getType() {
		
		return this.type;
	}//getType	
	
	public int getXCoord () {

		return this.xCoord;
	}//getXCoor
	
	public int getYCoord () {

		return this.yCoord;
	}//getYCoor
	
	public void setImage (String image) {
		
		this.image = new SimpleStringProperty(image);
	}//setImage String
	
	public void setWalkable (boolean walk) {
		
		this.isWalkable = new SimpleBooleanProperty (walk);
	}//setWalkable boolean
	
	public void setResident (MapResident res) {
		
		this.resident = res;
	}//setResidonte MapResident
	
	public void setType (String type) {
		
		this.type = new SimpleStringProperty(type);
	}//setType String
	
	public void setXCoord (int x) {
		
		this.xCoord = x;
	}//setX int
	
	public void setYCoord (int y) {
		
		this.yCoord = y;
	}//setY int
	
}//class
