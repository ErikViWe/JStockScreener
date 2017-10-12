package guiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Debug extends VBox {
	
	private HBox apiDebug;
	private HBox entryDebug;
	
	private Label lb_query;
	private Label lb_queryEntry;
	private Label lb_time;
	private Label lb_timeEntry;
	
	private Label lb_data;
	private Label lb_dataEntry;
	private Label lb_accuracy;
	private Label lb_accuracyEntry;
	
	
	public Debug() {
		initApiDebug();
		initEntryDebug();
		this.getChildren().addAll(apiDebug, entryDebug);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	private void initApiDebug() {
		apiDebug = new HBox();
		lb_query = new Label("Query sent: ");
		lb_queryEntry = new Label("no queries sent.");
		lb_time = new Label("Time needed: ");
		lb_timeEntry = new Label("n/a seconds.");
		
		apiDebug.getChildren().addAll(lb_query, lb_queryEntry, lb_time, lb_timeEntry);
		apiDebug.setSpacing(10);
	}
	
	private void initEntryDebug() {
		entryDebug = new HBox();
		lb_data = new Label("Amount of entries: ");
		lb_dataEntry = new Label("n/a entries.");
		lb_accuracy = new Label("Accuracy: ");
		lb_accuracyEntry = new Label("n/a %");
		
		entryDebug.getChildren().addAll(lb_data, lb_dataEntry, lb_accuracy, lb_accuracyEntry);
		entryDebug.setSpacing(10);
	}

}
