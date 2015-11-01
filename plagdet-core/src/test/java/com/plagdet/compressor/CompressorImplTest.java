package com.plagdet.compressor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CompressorImplTest {
	private static final String INPUT = "ababcbababaaaaaa";

	private CompressorImpl<String> compressor;

	@Before
	public void setUp() {
		compressor = new CompressorImpl<>();
	}

	@Test
	public void testEncode() throws Exception {
		final List<String> input = prepareInput(INPUT);

		final List<CodedTriple<String>> expected = new ArrayList<CodedTriple<String>>();
		expected.add(new CodedTriple<>(0, 0, "a"));
		expected.add(new CodedTriple<>(0, 0, "b"));
		expected.add(new CodedTriple<>(2, 2, "c"));
		expected.add(new CodedTriple<>(4, 3, "a"));
		expected.add(new CodedTriple<>(2, 3, "a"));
		expected.add(new CodedTriple<>(3, 2, "a"));

		final List<CodedTriple<String>> result = compressor.encode(input);
		assertThat(result).isEqualTo(expected);
	}

	private List<String> prepareInput(final String inputString) {
		final List<String> input = new ArrayList<>();
		for (final char c : inputString.toCharArray()) {
			input.add(String.valueOf(c));
		}

		return input;
	}
}
