package com.plagdet.tokenizer.lexers;

import static org.assertj.core.api.Assertions.assertThat;

import org.antlr.v4.runtime.Lexer;
import org.junit.Test;

public class LexerFactoryTest {
	@Test
	public void testGetLexer_Java8() throws Exception {
		final Lexer lexer = LexerFactory.getLexer(LexerType.Java8, null);
		
		assertThat(lexer).isInstanceOf(Java8Lexer.class);
	}
}
