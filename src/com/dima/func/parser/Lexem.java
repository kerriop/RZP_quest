package com.dima.func.parser;

import java.util.List;

public class Lexem extends LocationEntity {
	public LexemKind kind;
	public String value;
	public List<Lexem> childs;
	
	@Override
	public String toString() {
		return "Lexem{" +
				"kind=" + kind +
				", value='" + value + '\'' +
				'}';
	}
}
