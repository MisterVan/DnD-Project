package Project.World;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
	private static final int MOVE_SPEED = 4;
	
	private ArrayList<Hero> heros;
	private ArrayList<Monster> monsters;
	private Tile [][] map;							
	private Pane [][] realMap;						
	private VBox gameMap;
	
	private int index;
	private Hero currentPlayer;
	
	private GameWindowController parent;
	private boolean interact;
	
	public Map (String inputFile, VBox vbox, GameWindowController gwc) {
	
		this.gameMap = vbox;
		this.parent = gwc;
		this.heros = new ArrayList<Hero> ();
		this.monsters = new ArrayList<Monster> ();
		
		MapBuilderUtility util = new MapBuilderUtility(this);
		try {
			this.map = util.buildMap(inputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
					
		realMap = new Pane [map.length][map[0].length];
				
		loadFullArray();
		
	}//EVC
	
	private void loadFullArray() { 					//move to map object?
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
	            }//	            
	            
	            t.addEventHandler(MouseEvent.MOUSE_CLICKED, 
	            		new EventHandler<MouseEvent> () {
	    					@Override
	    					public void handle(MouseEvent arg0) {
	    						
	    						int xCoord = Integer.parseInt(t.getId());
	    						int yCoord = Integer.parseInt(hbox.getId());
	    						
	    						if (interact) {
	    							//target is passed to battle method in this class
	    							Hero target = (Hero) map[yCoord][xCoord].getResident();
	    							parent.setMessageBoxText("You interacted with " + target.getPlayerName() + " the " + target.getName());
	    							removeHighlights(xCoord, yCoord, 2);
	    							moveAlong();
	    							
	    						}//if interacting rather than moving
	    						
	    						else {
		    						move (t, xCoord, yCoord);		    							    						
		    						checkSurroundings (xCoord, yCoord);
	    						}//if just moving
	    						
	    					}//handle (MouseEvent	    
	    					
	            		});//new EventHandler, t.addEventFilter            
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
		}//
		else {
			moveAlong();
		}
		
	}//checkSurroundings
	
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
		
	}//move Pane, int, int
	
	private void getNextCharacter() {
		index++;
		if (index >= heros.size()){
			index = 0;
			//run loop for monsters moves, with status effects being applied at the end
		}//
		
		currentPlayer = heros.get(index);
		parent.setPlayerLabels(currentPlayer.getPlayerName(), currentPlayer.getName(), currentPlayer.getHP(), currentPlayer.getPrimaryWpn().description(),"", "");
		
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
		int max = MOVE_SPEED;
		
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
	
}//class
