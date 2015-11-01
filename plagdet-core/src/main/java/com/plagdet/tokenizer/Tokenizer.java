package com.plagdet.tokenizer;

import java.util.List;

import com.plagdet.tokenizer.lexers.LexerType;

/**
 * Interface for tokenizer
 * 
 * @author Lukasz Antkowiak
 *
 */
public interface Tokenizer {
	/**
	 * Tokenize given input
	 * 
	 * @param input
	 *            input to process
	 * @return list with token types
	 */
	List<Integer> tokenize(final LexerType lexerType, final String input);
}
