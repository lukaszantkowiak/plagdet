package com.plagdet.tokenizer.lexers;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;

/**
 * Factory for lexers
 * 
 * @author Luasz Antkowiak
 *
 */
public class LexerFactory {
	public static Lexer getLexer(final LexerType type, final ANTLRInputStream is) {
		switch (type) {
		case Java8:
			return new Java8Lexer(is);
		}
		throw new IllegalArgumentException("Unknown lexer type: " + type);
	}
}
