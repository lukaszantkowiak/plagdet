package com.plagdet.compressor;

import java.util.List;

/**
 * Interface for compressor
 * 
 * @author lantkowiak
 *
 * @param <T>
 */
public interface Compressor<T> {
	/**
	 * Encodes given input
	 * 
	 * @param input
	 *            input to encode
	 * @return encoded data
	 */
	List<CodedTriple<T>> encode(List<T> input);
}
