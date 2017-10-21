package indicators;

import financeApiComponents.Entry;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Macd extends VBox {
	
	private Label lb_name;
	private LineChart<String, Number> chart;
	private Separator separator;
	private CategoryAxis xAxis;
	private NumberAxis yAxis;
	private Entry[] data;
	private int span;
	private Button btn_info;
	
	public Macd(Entry[] data, Integer span) {
		this.data = data;
		this.span = span;
		init();
	}
	
	private void init() {
		lb_name = new Label("MACD:");
		lb_name.setFont(new Font(30));
		
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		yAxis.setSide(Side.RIGHT);
		
		btn_info = new Button("Info about MACD");
		
		
		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);
		
		this.getChildren().addAll(lb_name, chart, btn_info, separator);
		
	}

}
