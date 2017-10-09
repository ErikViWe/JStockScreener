package guiComponents;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Header contains components to specify the query.
 * @author Erik Weinstock
 * @version 1.0
 *
 */
public class Header extends HBox {
	
	private Label lb_stock;
	private TextField tf_stock;
	private ComboBox<String> dd_time_span;
	private Button btn_help;
	
	/**
	 * Constructor of the Header-Class creates a new header.
	 */
	public Header() {
		init();
	}
	
	/**
	 * Init-method to generate all GUI components and add it to the header.
	 */
	private void init() {
		lb_stock = new Label("Stock:");
		tf_stock = new TextField("SIN");
		dd_time_span = new ComboBox<String>();
		
		btn_help = new Button("Help");
		
		
		this.getChildren().addAll(lb_stock, tf_stock, dd_time_span, btn_help);
	}
	
	
	
}
