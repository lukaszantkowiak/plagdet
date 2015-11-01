package com.plagdet.kolmogorov;

import javax.inject.Singleton;

/**
 * Class is responsible for calculating Kolmogorov complexity
 * 
 * @author Lukasz Antkowiak
 *
 */
@Singleton
public class KolmogorovCalculatorImpl implements KolmogorovCalculator {

	@Override
	public KolmogorovCalculationResult calculate(final int encodedData1Size, final int encodedData2Size, final int encodedData1_2Size) {
		final double d = calculateD(encodedData1Size, encodedData2Size, encodedData1_2Size);

		final double px = calculateP(d, encodedData1Size, encodedData2Size);
		final double py = calculateP(d, encodedData2Size, encodedData1Size);

		return new KolmogorovCalculationResult(d, px, py);
	}

	private double calculateD(final int encodedData1Size, final int encodedData2Size, final int encodedData1_2Size) {
		return (encodedData1Size + encodedData2Size - encodedData1_2Size) / (1.0 * encodedData1_2Size);
	}

	private double calculateP(final double d, final int size1, final int size2) {
		final double a = size2 / (1.0 * size1);

		return (d * (a + 1)) / (d + 1.0);
	}
}
