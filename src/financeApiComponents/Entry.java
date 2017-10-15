package financeApiComponents;

import java.math.BigDecimal;
import java.util.Calendar;

public class Entry {
	
	private Calendar date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private Long volume;
	private String symbol;
	
	public Entry(Calendar date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, Long volume, String symbol) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.symbol = symbol;
	}
	
	public String getDay() {
		return String.valueOf(date.get(Calendar.DAY_OF_MONTH));
	}
	
	public String getMonth() {
		return String.valueOf(date.get(Calendar.MONTH) + 1);
	}
	
	public String getMonthValue() {
		Integer month = date.get(Calendar.MONTH) + 1;
		switch (month) {
        	case 1:  return "January";
        	case 2:  return "February";
        	case 3:  return "March";
        	case 4:  return "April";
        	case 5:  return "May";
        	case 6:  return "June";
        	case 7:  return "July";
        	case 8:  return "August";
        	case 9:  return "September";
        	case 10: return "October";
        	case 11: return "November";
        	default: return "December";
		}	
	}
	
	public String getYear() {
		return String.valueOf(date.get(Calendar.YEAR));
	}
	
	public BigDecimal getOpen() {
		return open;
	}
	
	public BigDecimal getHigh() {
		return high;
	}
	
	public BigDecimal getLow() {
		return low;
	}
	
	public BigDecimal getClose() {
		return close;
	}
	
	public long getVolume() {
		return volume;
	}
	
	public String getSymbol() {
		return symbol;
	}

}
