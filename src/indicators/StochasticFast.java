package indicators;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.ListIterator;

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

public class StochasticFast extends VBox {

	private Label lb_name;
	private LineChart<String, Number> chart;
	private XYChart.Series<String, Number> percentK;
	private XYChart.Series<String, Number> percentD;
	private Separator separator;
	private CategoryAxis xAxis;
	private NumberAxis yAxis;
	private Entry[] data;
	private int span;
	private Button btn_info;
	
	public StochasticFast(Entry[] data, Integer span) {
		this.data = data;
		this.span = span;
		init();
	}
	
	private void init() {
		lb_name = new Label("StochasticFast:");
		lb_name.setFont(new Font(30));
		
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		yAxis.setSide(Side.RIGHT);
		
		calcLine();
		
		chart = new LineChart<String, Number>(xAxis, yAxis);
		chart.setTitle("StochasticFast (14)");
		chart.getData().add(percentK);
		chart.getData().add(percentD);
		chart.setCreateSymbols(false);
		
		btn_info = new Button("Information about RSI");
		
		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);
		
		this.getChildren().addAll(lb_name, chart, btn_info, separator);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	private void calcLine() {
		percentK = new XYChart.Series<String, Number>();
		percentK.setName("%K");
		
		BigDecimal[] kLine = calcKLine(data, 14);
		BigDecimal[] dLine = MovingAverage.getAverage(kLine, 14);	
		int start = 0;
		if (data.length > span) {
			start = data.length - span - 1;
		}
		
		for (int i = start; i < data.length; i++) {
			percentK.getData().add(new XYChart.Data<>(data[i].getDate(), kLine[i]));
			percentD.getData().add(new XYChart.Data<>(data[i].getDate(), dLine[i]));
		}
	}
	
	private BigDecimal[] calcKLine(Entry[] arr, int n) {
		BigDecimal[] kLine = new BigDecimal[arr.length];
		BigDecimal max = arr[0].getClose();
		BigDecimal min = arr[0].getClose();
		kLine[0] = new BigDecimal(50); //set to 50 as it is the neutral value of the indicator
		LinkedList<BigDecimal> temp = new LinkedList<BigDecimal>();
		temp.add(arr[0].getClose());
		for (int i = 1; i < arr.length; i++) {
			ListIterator<BigDecimal> iterator = temp.listIterator();
			//remove values older than n days
			if (i >= n) {
				do {
					BigDecimal currentValue = iterator.next();
					if (currentValue.compareTo(arr[i - n].getClose()) == 0) {
						iterator.remove();
						break;
					}
				} while (iterator.hasNext());
				iterator = temp.listIterator();
			}
			
			
			//insert current closing price into the time window
			do { //assert temp.size() > 0
				BigDecimal currentValue = iterator.next();
				if (currentValue.compareTo(arr[i].getClose()) == 1) {
					iterator.previous();
					iterator.add(arr[i].getClose());
					break;
				} 
			} while (iterator.hasNext());
			
			//update min and max
			if (max.compareTo(arr[i].getClose()) == -1) {
				max = arr[i].getClose();
			}
			if (min.compareTo(arr[i].getClose()) == 1) {
				min = arr[i].getClose();
			}
			
			//calculate %K value
			kLine[i] = new BigDecimal(100).multiply((arr[i].getClose().subtract(min)).divide(max.subtract(min)));
		}
		
		return kLine;
	}
}
