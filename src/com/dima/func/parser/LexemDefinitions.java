package com.dima.func.parser;

/**
 * Определения лексем
 */
public class LexemDefinitions {
	
	public static StaticLexemDefinition[] statics = new StaticLexemDefinition[] {
			new StaticLexemDefinition("(", LexemKind.BRACE),
			new StaticLexemDefinition("*", LexemKind.MULTIPLY),
			new StaticLexemDefinition("/", LexemKind.DIVIDE),
			new StaticLexemDefinition("+", LexemKind.PLUS),
			new StaticLexemDefinition("-", LexemKind.MINUS),
			new StaticLexemDefinition(",", LexemKind.COMMA),
			new StaticLexemDefinition("^", LexemKind.POWER),
	};
	
	public static DynamicLexemDefinition[] dynamics = new DynamicLexemDefinition[] {
			new DynamicLexemDefinition("[0-9]+", LexemKind.NUMBER),
			new DynamicLexemDefinition("[a-zA-Z_][a-zA-Z0-9_]*", LexemKind.VARIABLE),
	};
}
