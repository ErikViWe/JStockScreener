package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * StockScreener contains essential methods and components. This class generates and displays the window.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class StockScreener extends Application {
	
	/**
	 * Constructor generates the StockScreener object.
	 * This constructor is executed at the javafx initialization time.
	 */
	public StockScreener() {
		
	}
	
	/**
	 * Executes the launch method to run the primaryStage.
	 */
	public static void run() {
		launch();
	}
	
	/**
	 * Initializes the ui and loads the components.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMaximized(true);
		primaryStage.setTitle("StockScreener");
		StackPane root = new StackPane();
		
		//TODO: add components to the scene
		
	    primaryStage.setScene(new Scene(root));
	    primaryStage.show();
		
	}
	
}
