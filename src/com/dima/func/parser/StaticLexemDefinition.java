package com.dima.func.parser;

/**
 * Статичная лексема на основании строки
 */
public class StaticLexemDefinition extends  LexemDefinition<String> {
	public boolean isKeyword;
	
	public StaticLexemDefinition(String representation, LexemKind kind, boolean isKeyword) {
		this.representation = representation;
		this.kind = kind;
		this.isKeyword = isKeyword;
	}
	
	public StaticLexemDefinition(String representation, LexemKind kind) {
		this.representation = representation;
		this.kind = kind;
		this.isKeyword = false;
	}
}