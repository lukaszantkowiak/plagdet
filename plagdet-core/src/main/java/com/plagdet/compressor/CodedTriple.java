package com.plagdet.compressor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Class stores coded triple for LZ77
 * 
 * @author Lukasz Antkowiak
 *
 * @param <T>
 */
public class CodedTriple<T> {
	private final int shift;
	private final int length;
	private final T next;

	/**
	 * Creates instance of {@link CodedTriple}
	 * 
	 * @param shift
	 *            left shift
	 * @param length
	 *            length
	 * @param next
	 *            next char
	 */
	public CodedTriple(final int shift, final int length, final T next) {
		this.shift = shift;
		this.length = length;
		this.next = next;
	}

	/**
	 * Gets shift
	 * 
	 * @return shift
	 */
	public int getShift() {
		return this.shift;
	}

	/**
	 * Gets length
	 * 
	 * @return length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Gets next char
	 * 
	 * @return next char
	 */
	public T getNext() {
		return this.next;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.shift).append(this.length).append(this.next).toHashCode();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		final CodedTriple<T> that = (CodedTriple<T>) obj;

		return new EqualsBuilder().append(this.shift, that.shift).append(this.length, that.length)
				.append(this.next, that.next).isEquals();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		return sb.append("(").append(this.shift).append(",").append(this.length).append(",").append(this.next)
				.append(")").toString();
	}
}
