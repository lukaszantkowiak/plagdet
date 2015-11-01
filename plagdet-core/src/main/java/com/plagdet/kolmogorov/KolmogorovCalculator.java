package com.plagdet.kolmogorov;


/**
 * Interface for calculating Kolmogorov complexity
 * 
 * @author lantkowiak
 *
 */
public interface KolmogorovCalculator {
	/**
	 * Calculates Kolmogorov complexity
	 * 
	 * @param data1
	 * @param data2
	 * @return Kolmogorov complexity
	 */
	KolmogorovCalculationResult calculate(final int encodedData1Size, final int encodedData2Size, final int encodedData1_2Size);
}
