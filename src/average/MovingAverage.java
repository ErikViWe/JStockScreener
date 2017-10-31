package average;

import java.math.BigDecimal;
import java.math.RoundingMode;

import financeApiComponents.Entry;

public class MovingAverage {

	public static BigDecimal[] getAverage(Entry[] data, int n) {
		BigDecimal[] arr = new BigDecimal[data.length];
		BigDecimal sum = new BigDecimal(0);
		for (int i = 0; i < data.length; i++) {
			sum = sum.add(data[i].getClose());
			if (i >= n) {
				sum = sum.subtract(data[i - n].getClose());
				arr[i] = sum.divide(new BigDecimal(n), 2, RoundingMode.HALF_UP);
			} else {
				if (i != 0) {
					arr[i] = sum.divide(new BigDecimal(i + 1), 2, RoundingMode.HALF_UP);
				} else {
					arr[i] = sum.setScale(2, RoundingMode.HALF_UP);
				}
			}	
		}
		return arr;
		
	}
	
	public static BigDecimal[] getRS(Entry[] data, int n) {
		BigDecimal[] arr = new BigDecimal[data.length];
		arr[0] = data[0].getClose();
		BigDecimal inc = data[0].getClose();
		BigDecimal dec = new BigDecimal(0);
		
		for (int i = 1; i < data.length; i++) {
			//Add close price to inc sum or dec sum depending if the price is rising or falling
			if (data[i].getClose().compareTo(data[i - 1].getClose()) == -1) {
				dec = dec.add(data[i].getClose());
			} else {
				inc = inc.add(data[i].getClose());
			}
			
			//Calculate relative strength
			if (dec.compareTo(BigDecimal.ZERO) == 0) {
				arr[i] = inc;
			} else {
				arr[i] = inc.divide(dec, 2, RoundingMode.HALF_UP);
			}
			
			//Subtract prices older than n days
			if (i >= n) {
				if (data[i - n].getClose().compareTo(data[i - n + 1].getClose()) == -1) {
					inc = inc.subtract(data[i - n].getClose());
				} else {
					dec = dec.subtract(data[i - n].getClose());
				}
			}
			
		}	
		return arr;
	}
	
}
