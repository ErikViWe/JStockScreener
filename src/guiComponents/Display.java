package guiComponents;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.VBox;

public class Display extends VBox {
	
	private LineChart<String, Number> chart;
	
	public Display() {
		init();
	}
	
	private void init() {
		//defining the axis
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Date");
		yAxis.setLabel("Price");
		
		chart = new LineChart<String, Number>(xAxis, yAxis);
		chart.setTitle("JStockScreener");
		
		Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("prices");
		
		//Empty series as placeholder	
		
		chart.getData().add(series);
		this.getChildren().add(chart);
	}

}