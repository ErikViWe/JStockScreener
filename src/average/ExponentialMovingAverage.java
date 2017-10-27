package average;

import java.math.BigDecimal;
import java.math.RoundingMode;

import financeApiComponents.Entry;

public class ExponentialMovingAverage {
	
	public static BigDecimal[] getExponentialAverage(Entry[] data, int n) {
		BigDecimal[] arr = new BigDecimal[data.length];
		BigDecimal alpha = new BigDecimal(2 / (double) (n + 1));
		BigDecimal alphaInv = new BigDecimal(1).subtract(alpha);
		System.out.println(alpha.doubleValue());
		System.out.println(alphaInv.doubleValue());
		arr[0] = data[0].getClose().setScale(2, RoundingMode.HALF_UP);
		for (int i = 1; i < data.length; i++) {
			arr[i] = data[i].getClose().multiply(alpha).add(arr[i - 1].multiply(alphaInv));
			System.out.println(n + ": " + arr[i].doubleValue());
		}
		return arr;
	}
	
	public static BigDecimal[] getExponentialAverage(BigDecimal[] data, int n) {
		BigDecimal[] arr = new BigDecimal[data.length];
		BigDecimal alpha = new BigDecimal(2 / (double) (n + 1));
		BigDecimal alphaInv = new BigDecimal(1).subtract(alpha);
		System.out.println(alpha.doubleValue());
		System.out.println(alphaInv.doubleValue());
		arr[0] = data[0];
		for (int i = 1; i < data.length; i++) {
			arr[i] = data[i].multiply(alpha).add(arr[i - 1].multiply(alphaInv));
			System.out.println(n + ": " + arr[i].doubleValue());
		}
		return arr;
	}

}
