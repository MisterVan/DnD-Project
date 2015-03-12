package Project.World;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Tile {
	
	private ImageView image;
	private boolean isWalkable;
	private MapResident resident;
	private StringProperty type;
	private int xCoord;  //make a location object??
	private int yCoord;  //make a location object??
	private ImageView highlight;
		
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
	
	public void setImage (Image image) {
		
		this.image = new ImageView (image);
	}//setImage String
	
	public void setWalkable (boolean walk) {
		
		this.isWalkable = walk;
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

	public void setHighlight(Image highlight) {
	
		this.highlight = new ImageView(highlight);
	}//setHighlight
	
}//class
