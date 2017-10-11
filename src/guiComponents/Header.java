package guiComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

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
	private Button btn_show;
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
		
		initLabelStock();
		initTextFieldStock();
		initComboBoxSpan();
		initButtonShow();
		initButtonHelp();
		
		
		this.getChildren().addAll(lb_stock, tf_stock, dd_time_span, btn_show, btn_help);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	private void initLabelStock() {
		lb_stock = new Label("Stock:");
		lb_stock.setPrefHeight(50);
		lb_stock.setAlignment(Pos.CENTER);
		lb_stock.setFont(new Font(30));
	}
	
	private void initTextFieldStock() {
		tf_stock = new TextField("SIN");
		tf_stock.setFont(new Font(30));
	}
	
	private void initComboBoxSpan() {
		dd_time_span = new ComboBox<String>();
		dd_time_span.setStyle("-fx-font: 30px \"System Regular\";");
		
		dd_time_span.getItems().addAll("5 Days", "10 Days", "3 Months", "6 Monts", "1 Year", "5 Years","∞");
		dd_time_span.setValue("5 Days");
	}
	
	private void initButtonShow() {
		btn_show = new Button("Show");
		btn_show.setFont(new Font(30));
		btn_show.setAlignment(Pos.CENTER);
	}
	
	private void initButtonHelp() {
		btn_help = new Button("Help");
		btn_help.setFont(new Font(30));
		btn_help.setAlignment(Pos.CENTER);
	}
	
	
}
