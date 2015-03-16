/**
 * 
 * @author Tim
 * 
 * The GUI code was based heavily one the tutorials found at:
 * "http://code.makery.ch/java/javafx-8-tutorial-part1/"
 * specifically parts 1-3
 * 
 */

package Project.World;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
		
	private Stage mainStage;
	private BorderPane mainPain;
	
	public Main () { }
	
	@Override	
	public void start(Stage primaryStage) throws IOException {		
		
		this.mainStage = primaryStage;
		
		initMainStage();
		//initDisplay();
		
		mainStage.show();
				
	}//start
	
	private void initDisplay() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("display2.fxml"));
		BorderPane infoPane = (BorderPane) loader.load();
		mainPain.setCenter(infoPane);
		
		
				
	}//initRight

	private void initMainStage() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		//loader.setLocation(Main.class.getResource("rootWindow.fxml"));
		loader.setLocation(Main.class.getResource("display2.fxml"));
		mainPain = (BorderPane) loader.load();
		
		Scene scene = new Scene (mainPain);
		mainStage.setTitle("Generic Dungeons and Dragons Game by Amber, Evan, and Tim");
		mainStage.setScene(scene);
						
	}//initMainStage

	public static void main(String[] args) {
		launch(args);
	}//main
	
}//class
