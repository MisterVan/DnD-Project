package Project.World;

public class TileFactory {
	
	public Tile createTile(int xCoord, int yCoord, String type) {
		
		Tile t;
		
		switch (type) {
		
		case "r":
			t = new RockTile(xCoord, yCoord);
			break;
		case "g":
			t = new GrassTile(xCoord, yCoord);
			break;
		case "": 
			t = new GrassTile(xCoord, yCoord);
			break;
		case "w":
			t = new WaterTile(xCoord, yCoord);
			break;
			
		default: //this should never happen, map wont have invalid options
			throw new IllegalStateException(); //singleton messagebox object that can have custom message?
		}//switchType	
				
		return t;
		
	}// createTile SP, int, int, String

}//class
