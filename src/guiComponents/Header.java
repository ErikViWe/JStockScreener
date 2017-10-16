package guiComponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import main.StockScreener;

/**
 * Header contains components to specify the query.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class Header extends HBox {
	
	private StockScreener stockScreener;
	private Label lb_stock;
	private TextField tf_stock;
	private ComboBox<String> dd_time_span;
	private Button btn_show;
	private Button btn_help;
	
	/**
	 * Constructor of the Header-Class creates a new header.
	 */
	public Header(StockScreener stockScreener) {
		this.stockScreener = stockScreener;
		init();
	}
	
	/**
	 * Init-method to generate all GUI components and add it to the header.
	 */
	private void init() {
		
		initLabelStock();
		initTextFieldStock();
		initComboBoxSpan();
		initButtonShow();
		initButtonHelp();
		initEventHandler();
		
		
		this.getChildren().addAll(lb_stock, tf_stock, dd_time_span, btn_show, btn_help);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	/**
	 * Initializes the stock label
	 */
	private void initLabelStock() {
		lb_stock = new Label("Stock:");
		lb_stock.setPrefHeight(50);
		lb_stock.setAlignment(Pos.CENTER);
		lb_stock.setFont(new Font(30));
	}
	
	/**
	 * Initializes the text field
	 */
	private void initTextFieldStock() {
		tf_stock = new TextField("SIN");
		tf_stock.setFont(new Font(30));
	}
	
	/**
	 * Initializes the combo box (dropdown menue) with the supported selections
	 */
	private void initComboBoxSpan() {
		dd_time_span = new ComboBox<String>();
		dd_time_span.setStyle("-fx-font: 30px \"System Regular\";");
		
		dd_time_span.getItems().addAll("5 Days", "10 Days", "3 Months", "6 Months", "1 Year", "5 Years","∞");
		dd_time_span.setValue("5 Days");
	}
	
	/**
	 * Initializes the show button
	 */
	private void initButtonShow() {
		btn_show = new Button("Show");
		btn_show.setFont(new Font(30));
		btn_show.setAlignment(Pos.CENTER);
	}
	
	/**
	 * Initializes the help button
	 */
	private void initButtonHelp() {
		btn_help = new Button("Help");
		btn_help.setFont(new Font(30));
		btn_help.setAlignment(Pos.CENTER);
	}
	
	private void initEventHandler() {
		btn_show.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				String sin = tf_stock.getText();
				String span = dd_time_span.getValue();
				stockScreener.display(sin, convertSpan(span));
			}
			
		});
	}
	
	private int convertSpan(String span) {
		switch (span) {
    	case "5 Days":  return 5;
    	case "10 Days":  return 10;
    	case "3 Months":  return 60;
    	case "6 Months":  return 120;
    	case "1 Year":  return 240;
    	case "5 Years":  return 1200;
    	default: return 0;
	}	
	}
	
	
}
