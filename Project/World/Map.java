package Project.World;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;




import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Project.Entity.Entity;
import Project.Entity.Hero.Hero;
import Project.Entity.Monster.Monster;
import Project.Item.Item;

public class Map {	
	
	private static final int SQUARE = 32;
		
	private ArrayList<Hero> heros;
	private ArrayList<Monster> monsters;
	boolean heroTurn;

	private Tile [][] map;							
	private Pane [][] realMap;						
	private VBox gameMap;
	
	private int index;

	private Entity currentPlayer;
	private Entity target;

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

			System.out.println("Couldn't find map file. This should only be an issue during testing");
			System.exit(-1);
		}					
		realMap = new Pane [map.length][map[0].length];
		heroTurn = true;
		index = 0;
		loadFullArray();
		
	}//EVC
	
	private void loadFullArray() { 

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

	            }//if mapResident	            

	            t.addEventHandler(MouseEvent.MOUSE_CLICKED, 
	            		new EventHandler<MouseEvent> () {
	    					@Override
	    					public void handle(MouseEvent arg0) {	    						

	    						parent.setMessageBoxText("");

	    						int xCoord = Integer.parseInt(t.getId());
	    						int yCoord = Integer.parseInt(hbox.getId());
	    						
	    						if (interact) {
	    							
	    							MapResident clicked = map[yCoord][xCoord].getResident();
	    							removeHighlights(xCoord, yCoord, 2);
	    							
	    							if (clicked instanceof Entity) {
	    							
		    							if (clicked.equals(currentPlayer)) {
		    								removeHighlights(xCoord, yCoord, currentPlayer.getSpeed());
		    								//playGame();
		    								moveAlong();
		    							}//if clicked self (do nothing)
		    							else {
		    							target = (Entity) clicked;
		    							target.setXCoord(xCoord);
		    							target.setYCoord(yCoord);
		    							doBattle (target);
		    							}
	    							}//if entity
		    							    							
	    							else { 
	    								Item itm = (Item) clicked;
	    								Hero temp = (Hero) currentPlayer;
	    								temp.addToInventory(itm);
	    								realMap[yCoord][xCoord].getChildren().remove(itm.getSprite());
	    								map[yCoord][xCoord].setResident(null);
	    								map[yCoord][xCoord].setWalkable(true);
	    								
	    								moveAlong();
	    							}//if item	    							
	    							    							
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
		target = null;
		if (heroTurn)
			moveAlong();
		
	}//executeAttack
	
	public void executeSpecialMove() {
		String result = "";
		result += currentPlayer.specialMove(target);
		result += checkDead();
		parent.setMessageBoxText(result);
		target = null;
		if (heroTurn)
			moveAlong();			
		
	}//executeSpecialMove
	
	private String checkDead() {
		String result = "";
		if (target.isDead()) {
			result += target.getName() + " has died!";
			int x = target.getXCoord();
			int y = target.getYCoord();
			realMap[y][x].setDisable(false);
			realMap[y][x].getChildren().remove(map[y][x].getResident().getSprite());
			map[y][x].setResident(null);
			map[y][x].setWalkable(true);
			realMap[y][x].setDisable(true);
			heros.remove(target);
			monsters.remove(target);	
						
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
		}
		else {
			moveAlong();
			//playGame();
		}
	
	}//checkSurroundings
	

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

	}//move Pane, int, int
	
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
		moveAlong();
				
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

		int max = currentPlayer.getSpeed();
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
		
	private void getNextCharacter() {
		index++;
		if (index >= heros.size()) {
			index = 0;
			heroTurn = false;
		}
		
		currentPlayer = heros.get(index);
		if (heroTurn) {
			Hero temp = (Hero) currentPlayer;
			parent.setPlayerLabels(temp.getName(), "" + temp.getHP(), temp.getPrimaryWpn().description(), 
					temp.getInventory().get(0).name==null?"":temp.getInventory().get(0).name, 
					temp.getInventory().get(1).name==null?"":temp.getInventory().get(1).name, 
					temp.getInventory().get(2).name==null?"":temp.getInventory().get(2).name);
		}//if hero turn
		else {
			
			parent.setPlayerLabels("", "", "", "", "", "");
			parent.setMessageBoxText("The monsters are taking their turns.... " + heroTurn);
			if (monsters.size() == 0)
				gameOver ("You win!!!");
			for (Monster m : monsters) {
				currentPlayer = m;
				doMonsterStuff();
				
			}
			heroTurn = true;
			if (heros.size() == 0)
				gameOver ("You lose!");
			currentPlayer = heros.get(index);
			Hero temp = (Hero) currentPlayer;
			parent.setPlayerLabels(temp.getName(), "" + temp.getHP(), temp.getPrimaryWpn().description(),"", "", "");
		}
		
	}//getNextCharacter
	
	private void gameOver(String string) {

		//parent.setMessageBoxText(string);
		//parent.disableScrollpane();
		
	}//

	public void moveAlong () {
		parent.setTargetLabels("", "");		
		getNextCharacter();
		displayMoveableTiles();
		
		interact = false;
	}//moveAlong

	private void doMonsterStuff() {
		
		monsterTurn();
		
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
		
		if (map[y+1][x].getResident() != null && map[y+1][x].getResident() instanceof Hero){
			move(realMap[y][x], x, y);
			monsterAttack(map[y+1][x].getResident());
			return true;
		}
		else if (map[y-1][x].getResident() != null && map[y+1][x].getResident() instanceof Hero){
			move(realMap[y][x], x, y);
			monsterAttack(map[y-1][x].getResident());
			return true;
		}
		else if (map[y][x+1].getResident() != null && map[y+1][x].getResident() instanceof Hero) {
			move(realMap[y][x], x, y);
			monsterAttack(map[y][x+1].getResident());
			return true;
		}
		else if (map[y][x-1].getResident() != null && map[y+1][x].getResident() instanceof Hero) {
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
	
}//class
