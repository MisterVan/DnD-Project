package Project.World;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Project.Entity.Entity;

public class GameWindowController implements Initializable {
	
	private static final String INPUT_FILE_NAME = "Project\\World\\map.csv";
			
	@FXML private VBox gameMap;	
	@FXML private Button option1;						
	@FXML private Button option2;						
	@FXML private Button option3;						
	@FXML private Button option4;						
	@FXML private Button option5;
	
	@FXML private ScrollPane scrollPane;			
	@FXML private TextArea messageBox;
	
	@FXML private Label playerNameLabel;
	@FXML private Label playerClass;
	@FXML private Label playerHPLabel;
	@FXML private Label playerWeaponLabel;
	@FXML private Label playerEquip1Label;
	@FXML private Label playerEquip2Label;
	@FXML private Label monsterNameLabel;
	@FXML private Label monsterHPLabel;
		
	private Button [] buttons;

	private Map map;
	private GameLogic game; 
	Entity currentPlayer;										//TESTING ONLY?	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.map = new Map (INPUT_FILE_NAME, gameMap, this);
		//this.game = new GameLogic (map);
		Button [] temp = {option1, option2, option3, option4, option5};
		buttons = temp;
		
		for (Button b : buttons) {
			b.setVisible(false);
		}
		map.playGame();
						
	}//initialize

	@FXML
	public void touchButt1() {
		
		for (Button b : buttons) {
			b.setVisible(false);
		}
		messageBox.setText("");
		map.moveAlong();		
								
	}//touchButt
	
	@FXML
	public void touchButt2() {
		
		
		
	}//touchButt
	
	@FXML
	public void touchButt3() {
		
		messageBox.setText("");
				
	}//touchButt
	
	@FXML
	public void touchButt4() {
		
		messageBox.setText("This is a string");
		
	}//touchButt
	
	public void setPlayerLabels(String name, String playerClass, int i, String weapon, String equip1, String equip2) {
		this.playerNameLabel.setText(name);
		this.playerClass.setText(playerClass);
		this.playerHPLabel.setText("" + i);
		this.playerWeaponLabel.setText(weapon);
		this.playerEquip1Label.setText(equip1);
		this.playerEquip2Label.setText(equip2);
		
	}//setPlayerLabels
	
	public void setMessageBoxText (String message) {
		
		this.messageBox.setText(message);
	}//setMessageBoxText String 
	
	public void setUpButtons (String textBox, ArrayList<String> args) {
		
		this.messageBox.setText(textBox);
		for (int i=0; i<args.size(); i++) {
			
			buttons[i].setVisible(true);
			buttons[i].setText(args.get(i));
			
		}//for s in args
		
	}//setUpButtons
		
}//class
