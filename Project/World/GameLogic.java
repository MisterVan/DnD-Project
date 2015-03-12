package Project.World;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import Project.Entity.Entity;

public class GameLogic {

	GameWindowController gwc;
	//Map reference (should be own class)
	Tile [][] map;
	Pane [][] realMap;
	ArrayList<Entity> list; //maybe have two for heros/monsters
	
	
	public GameLogic (GameWindowController gwc) {
		
		this.gwc = gwc;
	}//EVC
	
	public void playGame() {
		
		this.map = this.gwc.getMap();
		this.realMap = this.gwc.getRealMap();
		this.list = gwc.getCharacters();
		
		Entity blah = list.get(0);
		
		displayMovement (blah);
		
		
		//while (true)  {//have real logic here
			
			//for (Entity e : list) {
				
				//have to have some sort of pause for action. move other shit to new thread?
				
			//}//for entity in list
			
			
		//}//while true
		
		
	}//playGame Map

	private void displayMovement(Entity blah) {
		
		int speed = 2;
		boolean done;
		
		for (int i=1; i<=speed; i++) {
			
			for (int j=1; j<=speed; j++) {
				
				
			}//for j			
			
		}//
				
	}//
	
	
}//class
