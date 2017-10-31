package indicators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import average.MovingAverage;
import financeApiComponents.Entry;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Rsi extends VBox {
	
	private Label lb_name;
	private LineChart<String, Number> chart;
	private XYChart.Series<String, Number> rsi;
	private Separator separator;
	private CategoryAxis xAxis;
	private NumberAxis yAxis;
	private Entry[] data;
	private int span;
	private Button btn_info;
	
	public Rsi(Entry[] data, Integer span) {
		this.data = data;
		this.span = span;
		init();
	}
	
	private void init() {
		lb_name = new Label("RSI:");
		lb_name.setFont(new Font(30));
		
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		yAxis.setSide(Side.RIGHT);
		
		calcLine();
		
		chart = new LineChart<String, Number>(xAxis, yAxis);
		chart.setTitle("RSI (20)");
		chart.getData().add(rsi);
		chart.setCreateSymbols(false);
		
		btn_info = new Button("Information about RSI");
		
		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);
		
		this.getChildren().addAll(lb_name, chart, btn_info, separator);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	private void calcLine() {
		rsi = new XYChart.Series<String, Number>();
		rsi.setName("RSI");
		
		BigDecimal[] arr = MovingAverage.getRS(data, 14);
		for (int i = 0; i < arr.length; i++) {
			BigDecimal rsi_value = new BigDecimal(100).subtract(new BigDecimal(100).divide(new BigDecimal(1).add(arr[i]), 2, RoundingMode.HALF_UP));
			rsi.getData().add(new XYChart.Data<>(data[i].getDate(), rsi_value));
		}
	}

}
