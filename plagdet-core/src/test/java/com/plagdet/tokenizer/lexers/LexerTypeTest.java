package com.plagdet.tokenizer.lexers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LexerTypeTest {
	@Test
	public void testGetByName() throws Exception {
		final LexerType result = LexerType.getByName(LexerType.Java8.getName());

		assertThat(result).isEqualTo(LexerType.Java8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetByName_illegalName() throws Exception {
		LexerType.getByName("");
	}
}
