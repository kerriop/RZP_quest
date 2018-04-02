package com.dima.func.parser;

/**
 * Ошибка, возникающая при разборе исходного выражения на лексемы
 */
public class ParserException extends Exception {
	public ParserException() {
	}
	
	public ParserException(String s) {
		super(s);
	}
	
	public ParserException(String s, Throwable throwable) {
		super(s, throwable);
	}
	
	public ParserException(Throwable throwable) {
		super(throwable);
	}
	
	public ParserException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1);
	}
}