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
	
}
