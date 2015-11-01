//package com.plagdet.compressor.lz77;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import com.plagdet.compressor.CodedTriple;
//
//public class LZ77EncoderTest {
//	private static final String INPUT = "ababcbababaaaaaa";
//
//	@Test
//	public void testEncode_unlimitedBuffors() throws Exception {
//		final List<String> input = this.prepareInput(INPUT);
//		final LZ77Encoder<String> lz77Encoder = new LZ77Encoder<>();
//
//		final List<CodedTriple<String>> expected = new ArrayList<CodedTriple<String>>();
//		expected.add(new CodedTriple<>(0, 0, "a"));
//		expected.add(new CodedTriple<>(0, 0, "b"));
//		expected.add(new CodedTriple<>(2, 2, "c"));
//		expected.add(new CodedTriple<>(4, 3, "a"));
//		expected.add(new CodedTriple<>(2, 3, "a"));
//		expected.add(new CodedTriple<>(3, 2, "a"));
//
//		final List<CodedTriple<String>> result = lz77Encoder.encode(input);
//		assertEquals(expected.size(), result.size());
//		for (int i = 0; i < expected.size(); i++) {
//			assertEquals(expected.get(i), result.get(i));
//		}
//	}
//
//	private List<String> prepareInput(final String inputString) {
//		final List<String> input = new ArrayList<>();
//		for (final char c : inputString.toCharArray()) {
//			input.add(String.valueOf(c));
//		}
//
//		return input;
//	}
//}
