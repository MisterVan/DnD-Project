package Project.World;


import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Project.Entity.Entity;
import Project.Item.Consumable.*;

public class GameWindowController implements Initializable {
	
	
	private static final int SIZE = 19;				//remove?
	private static final int SQUARE = 32;
	private static final String INPUT_FILE_NAME = "Project\\World\\map.csv";
	private int xCurr;								//remove?
	private int yCurr;								//remove?
	
	private ArrayList<Entity> characters;			//Move to map object?
	private Tile [][] map;							//Move to map object?
	private Pane [][] realMap;						//Move to map object?
	
	@FXML private VBox gameMap;	
	@FXML private Button butt;						//TESTING ONLY
	@FXML private Button butt1;						//TESTING ONLY
	@FXML private Button butt2;						//TESTING ONLY
	@FXML private Button butt3;						//TESTING ONLY
	@FXML private ScrollPane scrollPane;			
	
	private GameLogic game; 
	Entity currentPlayer;										//TESTING ONLY?	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		characters = new ArrayList<Entity> ();
										
		MapBuilderUtility util = new MapBuilderUtility(this);
		try {
			map = util.buildMap(INPUT_FILE_NAME, SIZE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
					
		realMap = new Pane [map.length][map[0].length];
		
		xCurr = yCurr = 0;							//remove?
					
		loadFullArray();
		//loadArray(xCurr, yCurr);					//remove?
		game = new GameLogic (this);
		//game.playGame();
		
		currentPlayer = (Entity) map[1][1].getResident();
		
	}//initialize
	
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
	    						
	    						move (t, xCoord, yCoord);
	    						
	    						//placePotion (t, xCoord, yCoord);	    						
	    					}//handle (MouseEvent	                     	
	            		});//new EventHandler, t.addEventFilter            
	            
	            hbox.getChildren().add(t);	            
	       		 
	       	}//for j
	       	
	       	hbox.setId("" + i);
	       	temp.getChildren().add(hbox);
	       	 
	    }//for i
	   	 
	   	gameMap.getChildren().clear();
	   	gameMap.getChildren().addAll(temp.getChildren()); 
	}//loadFullArray
	
	private void move (Pane t, int xCoord, int yCoord) {
		
		//if(canMoveThere) (check for if only one square away)
		
		if (map[yCoord][xCoord].getWalkable()) {
			if (map[yCoord][xCoord].getResident() == null ) {
				
				int oldX = currentPlayer.getXCoord();
				int oldY = currentPlayer.getYCoord();
				
				map[yCoord][xCoord].setResident(currentPlayer);
				map[oldY][oldX].setResident(null);
				currentPlayer.setXCoord(xCoord);
				currentPlayer.setYCoord(yCoord);
				
				ImageView temp = map[yCoord][xCoord].getResident().getSprite();				
				temp.setFitHeight(32);
				temp.setFitWidth(32);
				t.getChildren().add(temp);   	    						    							
			}
			
		}
		
	}//
	
	private void placePotion(Pane t, int xCoord, int yCoord) {                //TESTING ONLY
		if (map[yCoord][xCoord].getWalkable()) {						
			if (map[yCoord][xCoord].getResident() == null ) {
				
				map[yCoord][xCoord].setResident(new PotionOfLife());
				ImageView temp = map[yCoord][xCoord].getResident().getSprite(); 
				temp.setFitHeight(32);
				temp.setFitWidth(32);
				t.getChildren().add(temp);   	    						    							
			}
			
			else {
				
				ImageView im = map[yCoord][xCoord].getResident().getSprite();
				map[yCoord][xCoord].setResident(null);
				t.getChildren().remove(im);	    							
			}
		}
		
	}//placePotion

	@FXML
	public void touchButt1() {
		
		if (xCurr+1 <= map[0].length - SIZE) {
			//xCurr++;
			//loadArray(xCurr, yCurr);
		}//
						
	}//touchButt
	
	@FXML
	public void touchButt2() {
		
		if (xCurr-1 >= 0) {
			//xCurr--;
			//loadArray(xCurr, yCurr);
		}
		
		realMap[2][1].getChildren().add(realMap[1][1].getChildren().get(1));
		
	}//touchButt
	
	@FXML
	public void touchButt3() {
		
		if (yCurr-1 >= 0) {
			//yCurr--;
			//loadArray(xCurr, yCurr);
		}
		
		ImageView t = new ImageView("Project\\World\\Potion.png");
		t.setFitWidth(32);
		t.setFitHeight(32);
		
		realMap[1][1].getChildren().add(t);
				
	}//touchButt
	
	@FXML
	public void touchButt4() {
		
		if (yCurr+1 <= map.length - SIZE) {
			//yCurr++;
			//loadArray(xCurr, yCurr);
		}//
			
		realMap[1][1].getChildren().remove(1);
		
	}//touchButt
/*	
	private void loadArray(int xOrigin, int yOrigin) { 					//KEEP UNTIL GUARENTEED TO BE ABLE TO MOVE SCROLLPANE FOCUS
		
	   	VBox temp = new VBox();
	   	 
	   	for (int i=yOrigin; i<SIZE+yOrigin; i++) {
	       	 
	   		HBox hbox = new HBox();
	       	 
	       	for (int j=xOrigin; j<SIZE+xOrigin; j++) {
	       	
	       		ImageView iv = new ImageView();
	       		
	       		Image im;
	       		String type = map[i][j].getSuperSimpleType();
	       		if (type.toLowerCase().equals("w"))
	       			im = images.get(0);
	       		else if (type.toLowerCase().equals("g") || type.equals(""))
	       			im = images.get(1);
	       		else // (type.toLowerCase().equals("r"))
	       			im = images.get(2);	   
	       			       		
	       		iv.setImage(im);
	       		iv.setFitWidth(SQUARE);
	            iv.setFitHeight(SQUARE);
	                
	            hbox.getChildren().add(iv);
	       		 
	       	}//for ja
	       	 
	       	temp.getChildren().add(hbox);
	       	 
	    }//for i
	   	 
	   	gameMap.getChildren().clear(); 
	   	gameMap.getChildren().addAll(temp.getChildren()); 
		
	}//loadArray

*/
	public void setCurrentPlayer (Entity ent) {
		
		this.currentPlayer = ent;
	}//setCurrentPlayer
	
	public void addCharacter(Entity r) {
		
		characters.add(r);
		
	}//addCharacter

	public ArrayList<Entity> getCharacters() {
		
		return this.characters;
	}//

	public Tile[][] getMap() {
		
		return this.map;
	}//getMap

	public Pane[][] getRealMap() {
		
		return this.realMap;
	}//getRealMap

}//class
