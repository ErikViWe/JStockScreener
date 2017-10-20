package guiComponents;

import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Selector extends VBox {
	
	private Label lb_avg;
	private Label lb_indicators;
	private CheckBox cb_3avg;
	private CheckBox cb_18avg;
	private CheckBox cb_38avg;
	private CheckBox cb_100avg;
	private CheckBox cb_200avg;
	private CheckBox cb_rsi;
	private CheckBox cb_macd;
	private CheckBox cb_stochasticSlow;
	private CheckBox cb_stochasticFast;
	private CheckBox cb_aroonUpDown;
	private CheckBox cb_aroonOscillator;
	private CheckBox cb_avgTrueRange;
	private CheckBox cb_commodityChannelIndex;
	private CheckBox cb_chaikinMoneyFlow;
	private CheckBox cb_chaikinOscillator;
	private CheckBox cb_directionalMovementIndex;
	private CheckBox cb_moneyFlowIndex;
	private CheckBox cb_negativeVolumeIndex;
	private CheckBox cb_positiveVolumeIndex;
	private CheckBox cb_rateOfChange;
	private CheckBox cb_stochasticRSI;
	private CheckBox cb_ultimateOscillator;
	private CheckBox cb_verticalHorizontalFilter;
	private CheckBox cb_volumePriceTrend;
	private CheckBox cb_williamsR;
	
	public Selector() {
		init();
	}
	
	private void init() {
		initLabels();
		initCheckBoxes();
		
		this.getChildren().addAll(lb_avg, cb_3avg, cb_18avg, cb_38avg, cb_100avg, cb_200avg, lb_indicators, cb_rsi, cb_macd,
				cb_stochasticSlow, cb_stochasticFast, cb_aroonUpDown, cb_aroonOscillator, cb_avgTrueRange, cb_commodityChannelIndex, 
				cb_chaikinMoneyFlow, cb_chaikinOscillator, cb_directionalMovementIndex, cb_moneyFlowIndex, cb_negativeVolumeIndex, cb_positiveVolumeIndex,
				cb_rateOfChange, cb_stochasticRSI, cb_ultimateOscillator, cb_verticalHorizontalFilter, cb_volumePriceTrend, cb_williamsR);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	private void initLabels() {
		lb_avg= new Label("Moving Averages:");
		lb_indicators = new Label("Indicators:");
	}
	
	private void initCheckBoxes() {
		cb_3avg = new CheckBox("3");
		cb_18avg = new CheckBox("18");
		cb_38avg = new CheckBox("38");
		cb_100avg = new CheckBox("100");
		cb_200avg = new CheckBox("200");
		cb_rsi = new CheckBox("RSI");
		cb_macd = new CheckBox("MACD");
		cb_stochasticSlow = new CheckBox("Stochastic Slow");
		cb_stochasticFast = new CheckBox("Stochastic Fast");
		cb_aroonUpDown = new CheckBox("Aroon Up/Down");
		cb_aroonOscillator = new CheckBox("Aroon Oscillator");
		cb_avgTrueRange = new CheckBox("Average True Range");
		cb_commodityChannelIndex = new CheckBox("Commodity Channel Index");
		cb_chaikinMoneyFlow = new CheckBox("Chaikin Money Flow");
		cb_chaikinOscillator = new CheckBox("Chaikin Oscillator");
		cb_directionalMovementIndex = new CheckBox("Directional Movement Index");
		cb_moneyFlowIndex = new CheckBox("Money Flow Index");
		cb_negativeVolumeIndex = new CheckBox("Negative Volume Index");
		cb_positiveVolumeIndex = new CheckBox("Positive Volume Index");
		cb_rateOfChange = new CheckBox("Rate Of Change");
		cb_stochasticRSI = new CheckBox("Stochastic RSI");
		cb_ultimateOscillator = new CheckBox("Ultimate Oscillator");
		cb_verticalHorizontalFilter = new CheckBox("Vertical Horizontal Filter");
		cb_volumePriceTrend = new CheckBox("Volume Priced Trend");
		cb_williamsR = new CheckBox("Williams %R");
		
	}
	
	public LinkedList<Integer> getMovingAverageSelection() {
		LinkedList<Integer> selection = new LinkedList<Integer>();
		
		if (cb_3avg.isSelected()) {
			selection.add(3);
		}
		
		if (cb_18avg.isSelected()) {
			selection.add(18);
		}
		
		if (cb_38avg.isSelected()) {
			selection.add(30);
		}
		
		if (cb_100avg.isSelected()) {
			selection.add(100);
		}
		
		if (cb_200avg.isSelected()) {
			selection.add(200);
		}
		
		return selection;
	}

}
