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
	
	/**
	 * Constructor generates an instance of a set of quotes.
	 * @param date
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 * @param symbol
	 */
	public Entry(Calendar date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, Long volume, String symbol) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.symbol = symbol;
	}
	
	/**
	 * Returns the day of month in a numerical format.
	 * @return
	 * 		day of month in numerical format
	 */
	public String getDay() {
		return String.valueOf(date.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * Returns the month of a year in numerical format.
	 * @return
	 * 		month of year in numerical format i.e. 1
	 */
	public String getMonth() {
		return String.valueOf(date.get(Calendar.MONTH) + 1);
	}
	
	/**
	 * Returns the month of a year in textual format. 
	 * @return
	 * 		month of year in textual format i.e. January
	 */
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
	
	/**
	 * Returns the year of the entry.
	 * @return
	 * 		year of entry in numerical format
	 */
	public String getYear() {
		return String.valueOf(date.get(Calendar.YEAR));
	}
	
	/**
	 * Returns the open price of the entry as BigDecimal.
	 * @return
	 * 		open price
	 */
	public BigDecimal getOpen() {
		return open;
	}
	
	/**
	 * Returns the highest price of the entry as BigDecimal.
	 * @return
	 * 		highest price
	 */
	public BigDecimal getHigh() {
		return high;
	}
	
	/**
	 * Returns the lowest price of the entry as BigDecimal.
	 * @return
	 * 		lowest price
	 */
	public BigDecimal getLow() {
		return low;
	}
	
	/**
	 * Returns close price of the entry as BigDecimal.
	 * @return
	 * 		close price
	 */
	public BigDecimal getClose() {
		return close;
	}
	
	/**
	 * Returns the volume of the Entry.
	 * @return
	 * 		volume
	 */
	public long getVolume() {
		return volume;
	}
	
	/**
	 * Returns the stock symbol. Note, the stock symbol is not the ISIN but the yahoo intern stock id.
	 * @return
	 * 		stock symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * Returns entry date in the correct display format.
	 * @return
	 * 		entry date
	 */
	public String getDate() {
		return this.getDay() + "." + this.getMonth() + "." + this.getYear();
	}

}
