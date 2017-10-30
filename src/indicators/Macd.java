package indicators;

import java.math.BigDecimal;

import average.ExponentialMovingAverage;
import financeApiComponents.Entry;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Macd extends VBox {
	
	private Label lb_name;
	private LineChart<String, Number> chart;
	private XYChart.Series<String, Number> macd;
	private XYChart.Series<String, Number> signal;
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
		
		calcLines();
		
		chart = new LineChart<String, Number>(xAxis, yAxis);
		chart.setTitle("MACD (12, 26, 9)");
		chart.getData().add(macd);
		chart.getData().add(signal);
		chart.setCreateSymbols(false);
		
		btn_info = new Button("Information about MACD");
		
		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);
		
		this.getChildren().addAll(lb_name, chart, btn_info, separator);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	private void calcLines() {
		//MACD line
		macd = new XYChart.Series<String, Number>();
		macd.setName("MACD");
		
		BigDecimal[] fasterAverage = ExponentialMovingAverage.getExponentialAverage(data, 12);
		BigDecimal[] difference = ExponentialMovingAverage.getExponentialAverage(data, 26);
		
		for (int i = 0; i < data.length; i++) {
			difference[i] = fasterAverage[i].subtract(difference[i]);
			macd.getData().add(new XYChart.Data<>(data[i].getDate(), difference[i]));
		}
		
		//Signal line
		signal = new XYChart.Series<String, Number>();
		signal.setName("Signal");
		
		BigDecimal[] signalAverage = ExponentialMovingAverage.getExponentialAverage(difference, 9);
		
		for (int i = 0; i < data.length; i++) {
			signal.getData().add(new XYChart.Data<>(data[i].getDate(), signalAverage[i]));
		}
	}

}
