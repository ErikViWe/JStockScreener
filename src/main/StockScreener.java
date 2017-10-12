package main;

import guiComponents.Debug;
import guiComponents.Display;
import guiComponents.Header;
import guiComponents.Selector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * StockScreener contains essential methods and components. This class generates and displays the window.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class StockScreener extends Application {
	
	private Header header;
	private Selector selector;
	private Display display;
	private Debug debug;
	
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
		header = new Header();
		selector = new Selector();
		display = new Display();
		debug = new Debug();
		
		primaryStage.setMaximized(true);
		primaryStage.setTitle("StockScreener");
		BorderPane root = new BorderPane();
		
		root.setTop(header);
		root.setRight(selector);
		root.setCenter(display);
		root.setBottom(debug);
		
	    primaryStage.setScene(new Scene(root));
	    primaryStage.show();
		
	}
	
}
