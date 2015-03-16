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
	private boolean wizardChoice;
		
	Entity currentPlayer;										//TESTING ONLY?	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.map = new Map (INPUT_FILE_NAME, gameMap, this);

		Button [] temp = {option1, option2, option3, option4, option5};
		buttons = temp;		
		hideButtons();
		messageBox.setText("Welcome to our game! May the odds be ever in your favour.\n\nClick on the red squares to move." + 
						   "If you're next to an item or another character, you then get the option of interacting with it." + 
						   "Scroll around on the map using the arrow keys.");
		monsterNameLabel.setText("");
		monsterHPLabel.setText("");

		map.playGame();
						
	}//initialize

	@FXML

	public void touchButton1() {
		map.executeAttack();
		hideButtons();								
	}//touchButton1
	
	@FXML
	public void touchButton2() {
		map.executeSpecialMove();		
		hideButtons();	
	}//touchButton2
	
	@FXML
	public void touchButton3() {
		
		hideButtons();					
	}//touchButton3
	
	@FXML
	public void touchButton4() {
		
		hideButtons();		
	}//touchButton4
	
	@FXML 
	public void touchButton5() {
		
		hideButtons();	
	}//touchButton5
	
	public void setPlayerLabels(String name, String playerClass, String hp, String weapon, String equip1, String equip2) {
		this.playerNameLabel.setText(name);
		this.playerClass.setText(playerClass);
		this.playerHPLabel.setText(hp);
		this.playerWeaponLabel.setText(weapon);
		this.playerEquip1Label.setText(equip1);
		this.playerEquip2Label.setText(equip2);
		
	}//setPlayerLabels
	
	public void setMessageBoxText (String message) {
		
		this.messageBox.setText(message);
	}//setMessageBoxText String 
	
	public void setUpButtons (String textBox, boolean wizChoice, String ... args) {
		
		this.messageBox.setText(textBox);
		for (int i=0; i<args.length; i++) {
			
			buttons[i].setVisible(true);
			buttons[i].setText(args[i]);
			
		}//for s in args
		
	}//setUpButtons

	public void setTargetLabels(String name, String hp) {
		this.monsterNameLabel.setText(name);
		this.monsterHPLabel.setText(hp);
	}//setTargetLabels;
	
	private void hideButtons () {
		
		for (Button b : buttons)
			b.setVisible(false);
	}//hideButtons

	public void disableScrollpane() {
		this.scrollPane.setDisable(true);
		
	}
			
}//class
