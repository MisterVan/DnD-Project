package Project.World;


import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameWindowController implements Initializable {
	
	private static final int SIZE = 19;
	private static final int SQUARE = 32;
	private static final String INPUT_FILE_NAME = "Project\\World\\map.csv";
	private int xCurr;
	private int yCurr;
	
	ArrayList<Image> images;
	
	private Main main;
	private Tile [][] map;
	private boolean toggle;
	
	@FXML
	private VBox gameMap;	
	@FXML
	private Button butt;
	@FXML
	private Button butt1;
	@FXML
	private Button butt2;
	@FXML
	private Button butt3;
	
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
					
		toggle = true;
		try {
			map = Util.buildMap(INPUT_FILE_NAME, SIZE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		xCurr = yCurr = 0;			
		//maybe use may for this?? Check it out
		images = new ArrayList <Image>();
		images.add(new Image ("Project\\World\\water.png"));
		images.add(new Image ("Project\\World\\TEXTURE_GRASS.png"));
		images.add(new Image ("Project\\World\\rock.jpeg"));
		
		loadFullArray();
		//loadArray(xCurr, yCurr);
		
	}//initialize
	
	private void loadFullArray() {
		VBox temp = new VBox();
	   	 
	   	for (int i=0; i<map.length; i++) {
	       	 
	   		HBox hbox = new HBox();
	       	 
	       	for (int j=0; j<map[i].length; j++) {
	       	
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
	}

	@FXML
	public void touchButt1() {
		
		if (xCurr+1 <= map[0].length - SIZE) {
			xCurr++;
			//loadArray(xCurr, yCurr);
		}//
		
	}//touchButt
	
	@FXML
	public void touchButt2() {
		
		if (xCurr-1 >= 0) {
			xCurr--;
			//loadArray(xCurr, yCurr);
		}
		
	}//touchButt
	
	@FXML
	public void touchButt3() {
		
		if (yCurr-1 >= 0) {
			yCurr--;
			//loadArray(xCurr, yCurr);
		}
		
	}//touchButt
	
	@FXML
	public void touchButt4() {
		
		if (yCurr+1 <= map.length - SIZE) {
			yCurr++;
			//loadArray(xCurr, yCurr);
		}//
		
	}//touchButt
	
	private void loadArray(int xOrigin, int yOrigin) {
		
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

	public void setMainApp(Main main) {
		
		this.main = main;
		
	}//setMainApp Main

}//class
