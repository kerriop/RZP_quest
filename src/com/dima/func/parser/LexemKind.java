package com.dima.func.parser;

/**
 * Тип лексемы
 */
public enum LexemKind {
	UNKNOWN,
	BRACE,
	PLUS, MINUS, MULTIPLY, DIVIDE,
	POWER,
	VARIABLE, NUMBER,
	COMMA,
}
