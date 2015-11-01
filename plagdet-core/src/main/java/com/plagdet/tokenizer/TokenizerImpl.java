package com.plagdet.tokenizer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;

import com.plagdet.tokenizer.lexers.LexerFactory;
import com.plagdet.tokenizer.lexers.LexerType;

/**
 * Implementation of tokenizer
 * 
 * @author Lukasz Antkowiak
 *
 */
@Singleton
public class TokenizerImpl implements Tokenizer {
	@Override
	public List<Integer> tokenize(final LexerType lexerType, final String input) {
		final Lexer lexer = LexerFactory.getLexer(lexerType, new ANTLRInputStream(input));

		final List<Integer> result = new ArrayList<>();

		lexer.getAllTokens().forEach(t -> result.add(t.getType()));

		return result;
	}
}
