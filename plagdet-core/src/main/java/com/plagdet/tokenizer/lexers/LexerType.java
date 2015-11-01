package com.plagdet.tokenizer.lexers;

/**
 * Lexer type
 * 
 * @author lantkowiak
 *
 */
public enum LexerType {
	Java8("Java 8");

	private final String name;

	private LexerType(final String name) {
		this.name = name;
	}

	/**
	 * Gets name of lexer type
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets LexerType for given name
	 * 
	 * @param name
	 *            name
	 * @return LexerType for given name
	 */
	public static LexerType getByName(final String name) {
		for (final LexerType lexerType : LexerType.values()) {
			if (lexerType.getName().equals(name)) {
				return lexerType;
			}
		}
		throw new IllegalArgumentException();
	}
}
