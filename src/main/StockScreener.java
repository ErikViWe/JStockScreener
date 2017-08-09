package main;

import javafx.application.Application;
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
	 */
	public StockScreener() {
		
	}
	
	public static void run() {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMaximized(true);
		primaryStage.setTitle("StockScreener");
		primaryStage.show();
		
	}
	
}
