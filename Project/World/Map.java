package Project.World;

import java.io.FileNotFoundException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Random;
=======
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Project.Entity.Entity;
import Project.Entity.Hero.Hero;
import Project.Entity.Monster.Monster;

public class Map {	
	
	private static final int SQUARE = 32;
<<<<<<< HEAD
		
	private ArrayList<Entity> characters;
=======
	private static final int MOVE_SPEED = 4;
	
	private ArrayList<Hero> heros;
	private ArrayList<Monster> monsters;
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	private Tile [][] map;							
	private Pane [][] realMap;						
	private VBox gameMap;
	
	private int index;
<<<<<<< HEAD
	private Entity currentPlayer;
	private Entity target;
=======
	private Hero currentPlayer;
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	
	private GameWindowController parent;
	private boolean interact;
	
	public Map (String inputFile, VBox vbox, GameWindowController gwc) {
	
		this.gameMap = vbox;
		this.parent = gwc;
<<<<<<< HEAD
		this.characters = new ArrayList<Entity> ();
				
=======
		this.heros = new ArrayList<Hero> ();
		this.monsters = new ArrayList<Monster> ();
		
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
		MapBuilderUtility util = new MapBuilderUtility(this);
		try {
			this.map = util.buildMap(inputFile);
		} catch (FileNotFoundException e) {
<<<<<<< HEAD
			System.out.println("Couldn't find map file. This should only be an issue during testing");
=======
			e.printStackTrace();
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
			System.exit(-1);
		}
					
		realMap = new Pane [map.length][map[0].length];
				
		loadFullArray();
		
	}//EVC
	
<<<<<<< HEAD
	private void loadFullArray() { 
=======
	private void loadFullArray() { 					//move to map object?
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
		VBox temp = new VBox();
	   	 
	   	for (int i=0; i<map.length; i++) {
	       	 
	   		HBox hbox = new HBox();
	       	 
	       	for (int j=0; j<map[i].length; j++) {
	       	
	       		Pane t = new Pane();	       		
	       		ImageView iv = map[i][j].getImage();
	       		iv.setFitHeight(SQUARE);
	       		iv.setFitWidth(SQUARE);
	            t.getChildren().add(iv);
	            t.setId("" + j); 
	            if (map[i][j].getResident() != null) {
	            	map[i][j].setWalkable(false);
	            	iv = map[i][j].getResident().getSprite();
	            	iv.setFitHeight(SQUARE);
		       		iv.setFitWidth(SQUARE);
	            	t.getChildren().add(iv);
<<<<<<< HEAD
	            }//if mapResident	            
=======
	            }//	            
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	            
	            t.addEventHandler(MouseEvent.MOUSE_CLICKED, 
	            		new EventHandler<MouseEvent> () {
	    					@Override
	    					public void handle(MouseEvent arg0) {
	    						
<<<<<<< HEAD
	    						parent.setMessageBoxText("");
	    						
=======
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	    						int xCoord = Integer.parseInt(t.getId());
	    						int yCoord = Integer.parseInt(hbox.getId());
	    						
	    						if (interact) {
<<<<<<< HEAD
	    							
	    							MapResident clicked = map[yCoord][xCoord].getResident();
	    							removeHighlights(xCoord, yCoord, 2);
	    							
	    							if (clicked instanceof Entity) {
	    							
		    							if (clicked.equals(currentPlayer)) {
		    								moveAlong();
		    							}//if clicked self (do nothing)
		    						
		    							target = (Entity) clicked;
		    							target.setXCoord(xCoord);
		    							target.setYCoord(yCoord);
		    							doBattle (target);
		    							
	    							}//if entity
		    							    							
	    							else { 
	    								
	    								//call item interaction method
	    							}//if item	    							
=======
	    							//target is passed to battle method in this class
	    							Hero target = (Hero) map[yCoord][xCoord].getResident();
	    							parent.setMessageBoxText("You interacted with " + target.getPlayerName() + " the " + target.getName());
	    							removeHighlights(xCoord, yCoord, 2);
	    							moveAlong();
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	    							
	    						}//if interacting rather than moving
	    						
	    						else {
		    						move (t, xCoord, yCoord);		    							    						
		    						checkSurroundings (xCoord, yCoord);
	    						}//if just moving
	    						
	    					}//handle (MouseEvent	    
	    					
<<<<<<< HEAD
	            		});//new EventHandler, t.addEventFilter   
	            
=======
	            		});//new EventHandler, t.addEventFilter            
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	            t.setDisable(true);
	            hbox.getChildren().add(t);	            
	       		realMap[i][j] = t;
	       	}//for j
	       	
	       	hbox.setId("" + i);
	       	temp.getChildren().add(hbox);
	       	 
	    }//for i
	   	 
	   	gameMap.getChildren().clear();
	   	gameMap.getChildren().addAll(temp.getChildren()); 
	}//loadFullArray
	
<<<<<<< HEAD

	private void doBattle(Entity target) {
		
		
		Hero temp = (Hero) currentPlayer;				
		String specialMove = temp.getSpecialName();
		String specialDescrip = temp.getSpecialDescription();
		parent.setTargetLabels(target.getName(), "" + target.getHP());
		parent.setUpButtons(specialMove + "\n" + specialDescrip, false, "Basic Attack", specialMove);
		
	}//doBattle
	
	public void executeAttack() {
		String result = "";		
		result += currentPlayer.performAttack(target);
		result += checkDead();
		parent.setMessageBoxText(result);
		moveAlong();
		
	}//executeAttack
	
	public void executeSpecialMove() {
		String result = "";
		result += currentPlayer.specialMove(target);
		result += checkDead();
		parent.setMessageBoxText(result);
		moveAlong();	
		
	}//executeSpecialMove
	
	private String checkDead() {
		String result = "";
		//System.out.println(target.getName());
		if (target.isDead()) {
			result += target.getName() + " has died!";
			int x = target.getXCoord();
			int y = target.getYCoord();
			realMap[y][x].setDisable(false);
			realMap[y][x].getChildren().remove(map[y][x].getResident().getSprite());
			map[y][x].setResident(null);
			map[y][x].setWalkable(true);
			realMap[y][x].setDisable(true);
			characters.remove(target);			
		}
		return result;
	}
	
	private void checkSurroundings(int x, int y) {
		
		if (map[y+1][x].getResident() != null){
			highlightIndividualTile(x, y+1);
			
		}
		if (map[y-1][x].getResident() != null){
			highlightIndividualTile(x, y-1);
		}
		if (map[y][x+1].getResident() != null) {
			highlightIndividualTile(x+1, y);
		}
		if (map[y][x-1].getResident() != null) {
			highlightIndividualTile(x-1, y);
		}		
		if (interact) {
			highlightIndividualTile(x, y);
			parent.setMessageBoxText("Which would you like to interact with? \n\nClick on yourself to do nothing.");
=======
	private void checkSurroundings(int x, int y) {
		
		if (map[y+1][x].getResident() != null){
			ImageView high = map[y+1][x].getHighlight();
			high.setFitHeight(SQUARE);
			high.setFitWidth(SQUARE);
			realMap[y+1][x].getChildren().add(high);
			realMap[y+1][x].setDisable(false);
			interact = true;
		}
		if (map[y-1][x].getResident() != null){
			ImageView high = map[y-1][x].getHighlight();
			high.setFitHeight(SQUARE);
			high.setFitWidth(SQUARE);
			realMap[y-1][x].getChildren().add(high);
			realMap[y-1][x].setDisable(false);
			interact = true;
		}
		if (map[y][x+1].getResident() != null) {
			ImageView high = map[y][x+1].getHighlight();
			high.setFitHeight(SQUARE);
			high.setFitWidth(SQUARE);
			realMap[y][x+1].getChildren().add(high);
			realMap[y][x+1].setDisable(false);
			interact = true;
		}
		if (map[y][x-1].getResident() != null) {
			ImageView high = map[y][x-1].getHighlight();
			high.setFitHeight(SQUARE);
			high.setFitWidth(SQUARE);
			realMap[y][x-1].getChildren().add(high);
			realMap[y][x-1].setDisable(false);
			interact = true;
		}
		
		if (interact) {
			parent.setMessageBoxText("Which would you like to interact with?");
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
		}//
		else {
			moveAlong();
		}
		
	}//checkSurroundings
	
<<<<<<< HEAD
	private void highlightIndividualTile(int x, int y) {
		ImageView high = map[y][x].getHighlight();
		high.setFitHeight(SQUARE);
		high.setFitWidth(SQUARE);
		realMap[y][x].getChildren().add(high);
		realMap[y][x].setDisable(false);
		interact = true;
		
	}//highlightIndividualTile
	
	private void move (Pane t, int xCoord, int yCoord) {				
				
		int oldX = currentPlayer.getXCoord();
		int oldY = currentPlayer.getYCoord();
		realMap[oldY][oldX].getChildren().remove(map[oldY][oldX].getResident().getSprite());
		map[oldY][oldX].setResident(null);
		map[oldY][oldX].setWalkable(true);			
		removeHighlights(oldX, oldY, currentPlayer.getSpeed());
		
		map[yCoord][xCoord].setResident(currentPlayer);
		map[yCoord][xCoord].setWalkable(false);
		currentPlayer.setXCoord(xCoord);
		currentPlayer.setYCoord(yCoord);
		ImageView temp = map[yCoord][xCoord].getResident().getSprite();				
		temp.setFitHeight(32);
		temp.setFitWidth(32);
		t.getChildren().add(temp); 		
=======
	private void move (Pane t, int xCoord, int yCoord) {
				
		if (realMap[yCoord][xCoord].getChildren().contains(map[yCoord][xCoord].getHighlight())) {
							
			int oldX = currentPlayer.getXCoord();
			int oldY = currentPlayer.getYCoord();
			realMap[oldY][oldX].getChildren().remove(map[oldY][oldX].getResident().getSprite());
			map[oldY][oldX].setResident(null);
			map[oldY][oldX].setWalkable(true);			
			removeHighlights(oldX, oldY, MOVE_SPEED);
			
			map[yCoord][xCoord].setResident(currentPlayer);
			map[yCoord][xCoord].setWalkable(false);
			currentPlayer.setXCoord(xCoord);
			currentPlayer.setYCoord(yCoord);
			ImageView temp = map[yCoord][xCoord].getResident().getSprite();				
			temp.setFitHeight(32);
			temp.setFitWidth(32);
			t.getChildren().add(temp); 
											
		}//tileisWalkables
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
		
	}//move Pane, int, int
	
	private void getNextCharacter() {
		index++;
<<<<<<< HEAD
		if (index >= characters.size()){
			index = 0;
			for (Entity e : characters)
				e.roundOver();
		}//if at end of list
		
		currentPlayer = characters.get(index);
		if (currentPlayer instanceof Hero) {
			Hero temp = (Hero) currentPlayer;	
			parent.setPlayerLabels(temp.getName(), "" + temp.getHP(), temp.getPrimaryWpn().description(),"", "", "");
		}//if hero  
		else { // if monster
			
			parent.setPlayerLabels("", "", "", "", "", "");
			parent.setMessageBoxText("The monsters are take their turns....");
						
		}//if monster
=======
		if (index >= heros.size()){
			index = 0;
			//run loop for monsters moves, with status effects being applied at the end
		}//
		
		currentPlayer = heros.get(index);
		parent.setPlayerLabels(currentPlayer.getPlayerName(), currentPlayer.getName(), currentPlayer.getHP(), currentPlayer.getPrimaryWpn().description(),"", "");
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
		
	}//getNextCharacter

	private void removeHighlights(int x, int y, int max) {
		
		int currStep = 0;
				
		realMap[y][x].getChildren().remove(map[y][x].getHighlight());
		realMap[y][x].setDisable(true);
		
		recursiveRemoveHighlights (x, y, currStep, max);		
		
	}//removeHighlights

	private void recursiveRemoveHighlights(int x, int y, int currStep, int max) {
		
		if (currStep > max) return;
		if (x<0 || x > map[0].length) return;
		if (y<0 || y > map.length) return;
		
		if (realMap[y][x].getChildren().contains(map[y][x].getHighlight())) {
			realMap[y][x].getChildren().remove(map[y][x].getHighlight());
			realMap[y][x].setDisable(true);
		}//if ther is a highlight
		
		recursiveRemoveHighlights (x, y-1, currStep+1, max);
		recursiveRemoveHighlights (x+1, y, currStep+1, max);
		recursiveRemoveHighlights (x, y+1, currStep+1, max);
		recursiveRemoveHighlights (x-1, y, currStep+1, max);
		
	}//recursizeRemoveHighlights

	public void playGame () {
		
		index = -1;
		getNextCharacter();
		displayMoveableTiles();
				
	}//playGame()
	
	private void displayMoveableTiles() {
				
		int x = currentPlayer.getXCoord();
		int y = currentPlayer.getYCoord();
		
		ImageView high = map[y][x].getHighlight();
		high.setFitHeight(SQUARE);
		high.setFitWidth(SQUARE);
		realMap[y][x].getChildren().add(high);
		realMap[y][x].setDisable(false);
		
		int currStep = 0;
<<<<<<< HEAD
		int max = currentPlayer.getSpeed();
=======
		int max = MOVE_SPEED;
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
		
		recursiveHighlighter(x, y, currStep, max);
		
	}//displayMovableTiles
	
	private void recursiveHighlighter (int x, int y, int currStep, int max) {
	
		if (currStep > max) return;
		if (x<0 || x > map[0].length) return;
		if (y<0 || y > map.length) return;
		if (!map[y][x].getWalkable() && currStep != 0) return;
		
		if (!realMap[y][x].getChildren().contains(map[y][x].getHighlight())) {
			ImageView high = map[y][x].getHighlight();
			high.setFitHeight(SQUARE);
			high.setFitWidth(SQUARE);
			realMap[y][x].getChildren().add(high);
			realMap[y][x].setDisable(false);
		}//if there isnt a highlight
		
		recursiveHighlighter (x, y-1, currStep+1, max);
		recursiveHighlighter (x, y+1, currStep+1, max);
		recursiveHighlighter (x+1, y, currStep+1, max);		
		recursiveHighlighter (x-1, y, currStep+1, max);
		
	}//recursiveHighligher int, int, int, int	
	
<<<<<<< HEAD
	public void addCharacter (Entity ent) {
		
		this.characters.add(ent);
		
	}//
		
	public void moveAlong () {
		parent.setTargetLabels("", "");
		getNextCharacter();	
		System.out.println(currentPlayer.getName());
		if (currentPlayer instanceof Monster)
			doMonsterStuff();
		else
			displayMoveableTiles();
		interact = false;
	}//moveAlong

	private void doMonsterStuff() {
		
		monsterTurn();
		moveAlong();
	}//doMonsterStuff

	private void monsterTurn() {
		
		int x = currentPlayer.getXCoord();
		int y = currentPlayer.getYCoord();
		
		int currStep = 0;
		int max = currentPlayer.getSpeed();
		recursiveMonsterMove (x, y, currStep, max, false);
		
	}//Monster move

	private void recursiveMonsterMove(int x, int y, int currStep, int max, boolean done) {
		
		if (done) return;
		if (currStep > max) return;
		if (x<0 || x > map[0].length) return;
		if (y<0 || y > map.length) return;
		if (!map[y][x].getWalkable() && currStep != 0) return;
		
		if (map[y][x].getResident() == null) {
			if(monsterCheckSurroundings(x, y))
				done = true;
			
		}//if there isnt a highlight
		
		recursiveMonsterMove (x, y-1, currStep+1, max, done);
		recursiveMonsterMove (x, y+1, currStep+1, max, done);
		recursiveMonsterMove (x+1, y, currStep+1, max, done);		
		recursiveMonsterMove (x-1, y, currStep+1, max, done);
		
	}//recursiveMonsterMove int, int, int, int

	private boolean monsterCheckSurroundings(int x, int y) {
		
		if (map[y+1][x].getResident() != null && map[y+1][x].getResident() instanceof Entity){
			move(realMap[y][x], x, y);
			monsterAttack(map[y+1][x].getResident());
			return true;
		}
		else if (map[y-1][x].getResident() != null && map[y+1][x].getResident() instanceof Entity){
			move(realMap[y][x], x, y);
			monsterAttack(map[y-1][x].getResident());
			return true;
		}
		else if (map[y][x+1].getResident() != null && map[y+1][x].getResident() instanceof Entity) {
			move(realMap[y][x], x, y);
			monsterAttack(map[y][x+1].getResident());
			return true;
		}
		else if (map[y][x-1].getResident() != null && map[y+1][x].getResident() instanceof Entity) {
			move(realMap[y][x], x, y);
			monsterAttack(map[y][x-1].getResident());
			return true;
		}		
		return false;
				
	}//mCheckSurroundings
	
	

	private void monsterAttack(MapResident resident) {
		
		target = (Entity) resident;
		
		Random rand = new Random();
		int move = rand.nextInt(100);
		if (move < 70)
			this.executeAttack();
		else
			this.executeSpecialMove();
		
	}//
=======
	public void addCharacter (Hero ent) {
		
		this.heros.add(ent);
	}//
	
	public void addCharacter (Monster ent) {
		
		this.monsters.add(ent);
	}//
	
	public void moveAlong () {
		getNextCharacter();		
		displayMoveableTiles();
		interact = false;
	}//moveAlong
>>>>>>> 1884630f38c34f7dd99fb1c459a2df1092287020
	
}//class
