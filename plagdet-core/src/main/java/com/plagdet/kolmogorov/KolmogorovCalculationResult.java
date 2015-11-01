package com.plagdet.kolmogorov;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Class stores result for calculation of Kolmogorov complexity
 * 
 * @author lantkowiak
 *
 */
public class KolmogorovCalculationResult {
	private final double d;
	private final double px;
	private final double py;

	/**
	 * Creates instance of {@link KolmogorovCalculationResult}
	 * 
	 * @param d kolmogorov complexity
	 * @param px 
	 * @param py
	 */
	public KolmogorovCalculationResult(final double d, final double px, final double py) {
		this.d = d;
		this.px = px;
		this.py = py;
	}

	public double getD() {
		return this.d;
	}

	public double getPx() {
		return this.px;
	}

	public double getPy() {
		return this.py;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
