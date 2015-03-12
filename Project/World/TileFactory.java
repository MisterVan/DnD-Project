package Project.World;

import java.util.ArrayList;

import Project.Entity.Hero.HeroFactory;
//import Project.World.MapResident;
import javafx.scene.image.Image;

public class TileFactory {
	
	ArrayList<Image> images;
	HeroFactory hFac;
	Image highlight;
	
	public TileFactory () {
		
		images = new ArrayList <Image>();
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_WATER.png"));         //0
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS.png"));  		//1
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_ROCK_1.png"));         //2
		
		highlight = new Image ("Project\\World\\highlight.png");
		
		hFac = new HeroFactory();
	}//DVC
	
	
	public Tile createTile(int xCoord, int yCoord, String type) {
		String type2 = type.toLowerCase();
		Tile t;
		MapResident e;
		
		switch (type2) {
		
		case "r":
			t = new RockTile(images.get(2), xCoord, yCoord);
			break;
		case "g":
			t = new GrassTile(images.get(1), xCoord, yCoord);
			break;
		case "": 
			t = new GrassTile(images.get(1), xCoord, yCoord);
			break;
		case " ":
			t = new GrassTile(images.get(1), xCoord, yCoord);
			break;
		case "w":
			t = new WaterTile(images.get(0), xCoord, yCoord);
			break;
		case "cleric": 
			t = new GrassTile (images.get(1), xCoord, yCoord);
			e = hFac.createHero(type);
			t.setResident(e); 
			break;
		default: //this should never happen, map wont have invalid options
			throw new IllegalStateException(); //singleton messagebox object that can have custom message?
		}//switchType	
		t.setHighlight(highlight);
		return t;
		
	}// createTile SP, int, int, String

}//class
