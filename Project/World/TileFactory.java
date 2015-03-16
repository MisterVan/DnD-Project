package Project.World;

import java.util.ArrayList;
import java.util.Random;

import Project.Entity.Hero.HeroFactory;
import Project.Entity.Monster.MonsterFactory;
import Project.Item.Item;
import Project.Item.ItemFactory;
//import Project.World.MapResident;
import javafx.scene.image.Image;


public class TileFactory {
	
	ArrayList<Image> images;
	HeroFactory hFac;
	MonsterFactory mFac;
	ItemFactory iFac;
	Image highlight;
	Random rand;
	
	public TileFactory () {
		
		images = new ArrayList <Image>();
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_WATER.png"));         //0
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS.png"));  		//1
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_ROCK_1.png"));         //2
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_ROCK_2.png"));         //3
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_ROCK_3.png"));         //4
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_ROCK_4.png"));         //5
		images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_PATH.png"));			//6
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_BOTTOM.png"));//7
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_TOP.png"));//8
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_LEFT.png"));//9
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_RIGHT.png"));//10
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_CORNER_NE.png"));//11
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_CORNER_NW.png"));//12
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_CORNER_SE.png"));//13
      images.add(new Image ("Project\\Sprites\\Terrain\\TEXTURE_GRASS_TO_SHORE_CORNER_SW.png"));//14
      
		highlight = new Image ("Project\\Sprites\\Terrain\\UTILITY_ATTACK_RED.png");
		
		hFac = new HeroFactory();
		mFac = new MonsterFactory();
		iFac = new ItemFactory();
		
	}//DVC
	
	
	public Tile createTile(int xCoord, int yCoord, String type) {
		String type2 = type.toLowerCase();
		Tile t;
		MapResident e;
		
		switch (type2) {
		
		case "r":			
			rand = new Random();
			int rando = rand.nextInt(4);
			t = new Tile(images.get(rando+2), xCoord, yCoord, highlight, false);
			break;
			
		case "g":
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			break;
			
		case "":			
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			break;
			
		case " ":			
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			break;
			
		case "w":			
			t = new Tile(images.get(0), xCoord, yCoord, highlight, false);
			break;
			
		case "cleric":			
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			e = hFac.createHero(type);
			t.setResident(e); 
			break;
			
		case "fighter":			
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			e = hFac.createHero(type);
			t.setResident(e);
			break;
			
		case "barbarian":			
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			e = hFac.createHero(type);
			t.setResident(e);
			break;
			
		case "wizard":			
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			e = hFac.createHero(type);
			t.setResident(e);
			break;
			
		case "p":			
			t = new Tile(images.get(6), xCoord, yCoord, highlight, true);
			break;
			
		case "m":
			t = new Tile(images.get(1), xCoord, yCoord, highlight, true);
			e = mFac.createRandomMonster();
			t.setResident(e);
			break;
			
		case "i":
			t = new Tile(images.get(1), xCoord, yCoord, highlight, false);
			Item item = iFac.createRandomItem();
			t.setResident(item);
			break;
			
      case "gtsb":
         t = new Tile(images.get(7), xCoord, yCoord, highlight, true);
         break;
      
      case "gtst":
         t = new Tile(images.get(8), xCoord, yCoord, highlight, true);
         break;
         
      case "gtsl":
         t = new Tile(images.get(9), xCoord, yCoord, highlight, true);
         break;
      
      case "gtsr":
         t = new Tile(images.get(10), xCoord, yCoord, highlight, true);
         break;
      
      case "gtscne":
         t = new Tile(images.get(11), xCoord, yCoord, highlight, true);
         break;
      
      case "gtscnw":
         t = new Tile(images.get(12), xCoord, yCoord, highlight, true);
         break;
      
      case "gtscse":
         t = new Tile(images.get(13), xCoord, yCoord, highlight, true);
         break;
      
      case "gtscsw":
         t = new Tile(images.get(14), xCoord, yCoord, highlight, true);
         break;


		default:			
			System.out.println("Ilegal option in map.csv: " + type + ", " + type2); // this will only happen during testing
			throw new IllegalStateException();
		}//switchType
				
		return t;
		
	}// createTile SP, int, int, String

}//class
