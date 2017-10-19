package guiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Information extends VBox {
	
	private Label lb_name;
	private Label lb_name_value;
	private Label lb_currency;
	private Label lb_currency_value;
	private Label lb_stockExchange;
	private Label lb_stockExchange_value;
	private Label lb_annualYield;
	private Label lb_annualYield_value;
	private Label lb_annualYieldPercent;
	private Label lb_annualYieldPercent_value;
	
	
	
	public Information() {
		init();
	}
	
	private void init() {
		
		//name
		HBox name = new HBox();
		lb_name = new Label("Name: ");
		lb_name_value = new Label("");
		name.getChildren().addAll(lb_name, lb_name_value);
		
		//currency
		HBox currency = new HBox();
		lb_currency = new Label("Currency: ");
		lb_currency_value = new Label("");
		currency.getChildren().addAll(lb_currency, lb_currency_value);
		
		//stockExchange
		HBox stockExchange = new HBox();
		lb_stockExchange = new Label("Stock Exchange: ");
		lb_stockExchange_value = new Label("");
		stockExchange.getChildren().addAll(lb_stockExchange, lb_stockExchange_value);
		
		//annualYield
		HBox annualYield = new HBox();
		lb_annualYield = new Label("Annual Yield: ");
		lb_annualYield_value = new Label("");
		annualYield.getChildren().addAll(lb_annualYield, lb_annualYield_value);
		
		//annualYieldPercentage
		HBox annualYieldPercent = new HBox();
		lb_annualYieldPercent = new Label("Annual Yield Percent: ");
		lb_annualYieldPercent_value = new Label("");
		annualYieldPercent.getChildren().addAll(lb_annualYieldPercent, lb_annualYieldPercent_value);
		
		this.getChildren().addAll(name, currency, stockExchange, annualYield, annualYieldPercent);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
	}
	
	public void setName(String name) {
		lb_name_value.setText(name);
	}
	
	public void setCurrency(String currency) {
		lb_currency_value.setText(currency);
	}
	
	public void setStockExchange(String stockExchange) {
		lb_stockExchange_value.setText(stockExchange);
	}
	
	public void setAnnualYield(String annualYield) {
		lb_annualYield_value.setText(annualYield);
	}
	
	public void setAnnualYieldPercent(String annualYieldPercent) {
		lb_annualYieldPercent_value.setText(annualYieldPercent);
	}
	
}
