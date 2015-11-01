package com.plagdet.tokenizer;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.plagdet.tokenizer.lexers.LexerType;

public class TokenizerImplTest {
	private static final String INPUT_FILE = "HelloWorld.java";
	private static final String RESULT_FILE = "result.txt";

	private TokenizerImpl tokenizer;

	@Before
	public void setUp() {
		this.tokenizer = new TokenizerImpl();
	}

	@Test
	public void testTokenize() throws Exception {
		final String input = this.readResurceFile(INPUT_FILE);

		final List<Integer> result = this.tokenizer.tokenize(LexerType.Java8, input);

		final List<Integer> expected = this.createIntegerList(this.readResurceFile(RESULT_FILE));

		assertEquals(expected.size(), result.size());
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i), result.get(i));
		}
	}

	private String readResurceFile(final String filename) throws IOException {
		final StringBuilder sb = new StringBuilder();

		try (final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
				final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		}

		return sb.toString();
	}

	private List<Integer> createIntegerList(final String input) {
		final List<Integer> result = new ArrayList<>();

		Arrays.asList(input.split(", ")).forEach(e -> result.add(Integer.valueOf(e)));

		return result;
	}
}
