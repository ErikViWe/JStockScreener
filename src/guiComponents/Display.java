package guiComponents;

import java.math.BigDecimal;
import java.math.RoundingMode;

import financeApiComponents.Entry;
import javafx.geometry.Orientation;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class Display extends VBox {
	
	private LineChart<String, Number> chart;
	private Separator separator;
	private CategoryAxis xAxis;
	private NumberAxis yAxis;
	
	public Display() {
		init();
	}
	
	private void init() {
		//defining the axis
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		
		xAxis.setLabel("Date");
		yAxis.setLabel("Price");
		
		chart = new LineChart<String, Number>(xAxis, yAxis);
		chart.setTitle("JStockScreener");
		
		Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("prices");
		
		//Empty series as placeholder	
		
		chart.getData().add(series);
		this.getChildren().add(chart);
		
		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);
		
		this.getChildren().add(separator);
		this.setSpacing(10);
	}
	
	public void show(Entry[] data, Integer span, String name) {
		
		Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("Prices of: " + name);
		
		int start = 0;
		BigDecimal min = data[data.length - 1].getClose().setScale(2, RoundingMode.HALF_UP);
		BigDecimal max = data[data.length - 1].getClose().setScale(2, RoundingMode.HALF_UP);
		if (data.length > span) {		
			start = data.length - span - 1;
		}
		for (int i = start; i < data.length; i++) {
			BigDecimal price = data[i].getClose().setScale(2, RoundingMode.HALF_UP);
			series.getData().add(new XYChart.Data<>(data[i].getDate(), price));
			if (price.compareTo(min) == -1) {
				min = price;
			}
			
			if (price.compareTo(max) == 1) {
				max = price;
			}
			
		}
		
		min = min.subtract(min.divide(new BigDecimal(100))).setScale(0, RoundingMode.HALF_UP);
		max = max.setScale(0, RoundingMode.HALF_UP);
		
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		yAxis.setAutoRanging(false);
		yAxis.setUpperBound(max.doubleValue());
		yAxis.setLowerBound(min.doubleValue());
		
		xAxis.setLabel("Date");
		yAxis.setLabel("Price");
		
		chart = new LineChart<String, Number>(xAxis, yAxis);
		
		chart.setTitle(name);
		chart.getData().add(series);
		chart.setCreateSymbols(false);
		
		this.getChildren().clear();
		this.getChildren().addAll(chart, separator);
	}

}
