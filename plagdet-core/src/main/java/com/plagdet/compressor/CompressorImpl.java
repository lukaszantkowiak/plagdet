package com.plagdet.compressor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Class is responsible for encoding and decoding data
 * 
 * @author lantkowiak
 *
 * @param <T>
 */
@Singleton
public class CompressorImpl<T> implements Compressor<T> {

	@Override
	public List<CodedTriple<T>> encode(final List<T> input) {
		final List<CodedTriple<T>> coded = new ArrayList<CodedTriple<T>>();
		coded.add(new CodedTriple<T>(0, 0, input.get(0)));

		for (int i = 1; i < input.size(); i++) {
			final List<T> dictionary = this.getDictionary(i, input);
			final CodedTriple<T> codedTriple = this.findLongestPrefix(i, input, dictionary);
			coded.add(codedTriple);
			i += codedTriple.getLength();
		}

		return coded;
	}

	private List<T> getDictionary(final int index, final List<T> input) {
		return input.subList(0, index);
	}

	private CodedTriple<T> findLongestPrefix(final int position, final List<T> input, final List<T> dictionary) {
		int i = position + 1;
		ShiftLength last = new ShiftLength(0, 0);
		ShiftLength positionLength;

		while (i < input.size()
				&& (positionLength = this.findSequence(input.subList(position, i), dictionary)).getShift() > 0) {
			i++;
			last = positionLength;
		}
		return new CodedTriple<T>(last.getShift(), last.getLength(), input.get(position + last.getLength()));
	}

	// naive algorithm is used; it is slow...
	private ShiftLength findSequence(final List<T> sequence, final List<T> dictionary) {
		boolean found = false;
		for (int i = 0; i < dictionary.size(); i++) {
			for (int j = 0; j < sequence.size(); j++) {
				if (!sequence.get(j).equals(this.getDictionaryElement(i + j, dictionary))) {
					found = false;
					break;
				} else {
					found = true;
				}
			}
			if (found) {
				return new ShiftLength(dictionary.size() - i, sequence.size());
			}
		}

		return new ShiftLength(0, 0);
	}

	private T getDictionaryElement(final int position, final List<T> dictionary) {
		return dictionary.get(position % dictionary.size());
	}

	private static class ShiftLength {
		private final int shift;
		private final int length;

		public ShiftLength(final int shift, final int length) {
			this.shift = shift;
			this.length = length;
		}

		public int getShift() {
			return this.shift;
		}

		public int getLength() {
			return this.length;
		}
	}
}
