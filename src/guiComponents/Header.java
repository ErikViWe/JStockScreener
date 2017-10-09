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
		lb_stock.setMinHeight(20);
		lb_stock.setMaxHeight(75);
		lb_stock.setPrefWidth(200);
		lb_stock.setMinWidth(100);
		lb_stock.setMaxWidth(250);
		lb_stock.setAlignment(Pos.CENTER);
		lb_stock.setFont(new Font(40));
	}
	
	private void initTextFieldStock() {
		tf_stock = new TextField("SIN");
		tf_stock.setPrefHeight(50);
		tf_stock.setMinHeight(20);
		tf_stock.setMaxHeight(75);
		tf_stock.setPrefWidth(200);
		tf_stock.setMinWidth(100);
		tf_stock.setMaxWidth(250);
		tf_stock.setFont(new Font(40));
	}
	
	private void initComboBoxSpan() {
		dd_time_span = new ComboBox<String>();
		dd_time_span.setPrefHeight(50);
		dd_time_span.setMinHeight(20);
		dd_time_span.setMaxHeight(75);
		dd_time_span.setPrefWidth(350);
		dd_time_span.setMinWidth(250);
		dd_time_span.setMaxWidth(450);
		dd_time_span.setStyle("-fx-font: 30px \"Serif\";");
		
		dd_time_span.getItems().addAll("5 Days", "10 Days", "3 Months", "6 Monts", "1 Year", "5 Years","∞");
		dd_time_span.setValue("5 Days");
	}
	
	private void initButtonShow() {
		btn_show = new Button("Show");
		btn_show.setPrefHeight(50);
		btn_show.setMinHeight(20);
		btn_show.setMaxHeight(75);
		btn_show.setPrefWidth(200);
		btn_show.setMinWidth(100);
		btn_show.setMaxWidth(250);
		btn_show.setFont(new Font(40));
		btn_show.setAlignment(Pos.CENTER);
	}
	
	private void initButtonHelp() {
		btn_help = new Button("Help");
		btn_help.setPrefHeight(50);
		btn_help.setMinHeight(20);
		btn_help.setMaxHeight(75);
		btn_help.setPrefWidth(200);
		btn_help.setMinWidth(100);
		btn_help.setMaxWidth(250);
		btn_help.setFont(new Font(40));
		btn_help.setAlignment(Pos.CENTER);
	}
	
	
	
}
