package com.dima.func.parser;

import java.util.regex.Pattern;

/**
 * Лексема на основании регулярного выражения
 */
public class DynamicLexemDefinition extends LexemDefinition<Pattern> {
	
	public DynamicLexemDefinition(String representation, LexemKind kind) {
		this.representation = Pattern.compile("\\G" + representation);
		this.kind = kind;
	}
	
	public DynamicLexemDefinition(String representation, LexemKind kind, String flags) {
		this.representation = Pattern.compile("\\G" + flags + representation);
		this.kind = kind;
	}
}
