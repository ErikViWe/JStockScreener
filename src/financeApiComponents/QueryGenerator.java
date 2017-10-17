package financeApiComponents;

import java.io.IOException;
import java.util.ArrayList;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

public class QueryGenerator {
	
	private Stock stock;
	private Entry[] data;
	private String symbol;
	
	public QueryGenerator() {
		
	}
	
	public void fetchStockData(String id) {
		try {
			this.stock = YahooFinance.get(id, Interval.DAILY);
			formatData();
			symbol = id;
		} catch (IOException e) {
			System.out.println("Error, invalid stock id.");
		}
	}
	
	public String getStockExchange() {
		return stock.getStockExchange();
	}
	
	public String getCurrency() {
		return stock.getCurrency();
	}
	
	public String getName() {
		return stock.getName();
	}
	
	public String getPayDate() {
		return stock.getDividend().getPayDate().toString();
	}
	
	public String getExDate() {
		return stock.getDividend().getExDate().toString();
	}
	
	public String getAnnualYield() {
		return stock.getDividend().getAnnualYield().toString();
	}
	
	public String getAnnualYieldPercent() {
		return stock.getDividend().getAnnualYieldPercent().toString();
	}
	
	public Entry[] getData() {	
		return data;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	private void formatData() throws IOException {
		ArrayList<HistoricalQuote> temp = (ArrayList<HistoricalQuote>) stock.getHistory();
		data =  new Entry[temp.size()];		
		for (int i = 0; i < temp.size(); i++) {
			HistoricalQuote quote = temp.get(i);
			Entry entry = new Entry(quote.getDate(),
					quote.getOpen(), 
					quote.getHigh(), 
					quote.getLow(), 
					quote.getClose(), 
					quote.getVolume(), 
					quote.getSymbol());
			data[i] = entry;
		}
		
	}
	

}
