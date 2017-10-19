package guiComponents;

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
		
		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);
		this.getChildren().add(separator);
		this.setSpacing(10);
	}
	
	public void show(Entry[] data, Integer span, String name) {
		chart.setTitle(name);
		Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("Prices of: " + name);
		if (data.length <= span) {		
			for (int i = 0; i < data.length; i++) {
				series.getData().add(new XYChart.Data<>(data[i].getDate(), data[i].getClose().setScale(2, RoundingMode.HALF_UP)));
			}
		} else {
			int start = data.length - span - 1;
			for (int i = start; i < data.length; i++) {
				series.getData().add(new XYChart.Data<>(data[i].getDate(), data[i].getClose().setScale(2, RoundingMode.HALF_UP)));
			}
		}
		chart.getData().remove(0);
		chart.getData().add(series);
		chart.setCreateSymbols(false);
	}

}
