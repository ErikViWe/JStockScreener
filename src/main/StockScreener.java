package main;

import average.Average;
import financeApiComponents.QueryGenerator;
import guiComponents.Debug;
import guiComponents.Display;
import guiComponents.Header;
import guiComponents.Information;
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
	private Information information;
	private Selector selector;
	private Display display;
	private Debug debug;
	private QueryGenerator query;
	
	/**
	 * Constructor generates the StockScreener object as well as the query object.
	 * This constructor is executed at the javafx initialization time.
	 */
	public StockScreener() {
		query = new QueryGenerator();
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
		header = new Header(this);
		information = new Information();
		selector = new Selector();
		display = new Display();
		debug = new Debug();
		
		primaryStage.setMaximized(true);
		primaryStage.setTitle("StockScreener");
		BorderPane root = new BorderPane();
		
		root.setTop(header);
		root.setLeft(information);
		root.setRight(selector);
		root.setCenter(display);
		root.setBottom(debug);
		
	    primaryStage.setScene(new Scene(root));
	    primaryStage.show();
		
	}
	
	public void display(String isin, Integer span) {
		if (!isin.equals(query.getSymbol())) {
			query.fetchStockData(isin);
		}
		
		display.show(query.getData(), span, query.getName());
		
		//Display moving averages selected
		for (int n : selector.getMovingAverageSelection()) {
			display.showAverage(Average.getAverage(query.getData(), n), n);
		}
		
		information.setName(query.getName());
		information.setCurrency(query.getCurrency());
		information.setStockExchange(query.getStockExchange());
		information.setAnnualYield(query.getAnnualYield());
		information.setAnnualYieldPercent(query.getAnnualYieldPercent());
	}
	
}
