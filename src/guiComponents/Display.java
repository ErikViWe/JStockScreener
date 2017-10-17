package guiComponents;

import financeApiComponents.Entry;
import javafx.geometry.Orientation;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class Display extends VBox {
	
	private LineChart<String, String> chart;
	private Separator separator;
	
	public Display() {
		init();
	}
	
	private void init() {
		//defining the axis
		final CategoryAxis xAxis = new CategoryAxis();
		final CategoryAxis yAxis = new CategoryAxis();
		
		xAxis.setLabel("Date");
		yAxis.setLabel("Price");
		
		chart = new LineChart<String, String>(xAxis, yAxis);
		chart.setTitle("JStockScreener");
		
		Series<String, String> series = new XYChart.Series<String, String>();
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
		Series<String, String> series = new XYChart.Series<String, String>();
		series.setName("Prices of: " + name);
		if (data.length <= span) {		
			for (int i = 0; i < data.length; i++) {
				System.out.println("Print1 index" + i + ":" + data[i].getClose().toString());
				series.getData().add(new XYChart.Data<>(data[i].getDate(), data[i].getClose().toPlainString()));
			}
		} else {
			int start = data.length - span - 1;
			for (int i = start; i < data.length; i++) {
				System.out.println("Print2 index" + i + ":" + data[i].getClose().toString());
				series.getData().add(new XYChart.Data<>(data[i].getDate(), data[i].getClose().toPlainString()));
			}
		}
		chart.getData().remove(0);
		chart.getData().add(series);
	}

}
