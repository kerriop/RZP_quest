package com.dima.func.compiled;

import com.dima.func.parser.Lexem;
import com.dima.func.parser.LexemKind;

import java.util.ArrayList;
import java.util.List;

public class OperationParser {
	
	private static List<Operation> parseFunctionArgs(Lexem brace) throws CompileException {
		List<Lexem> lexems = brace.childs;
		List<Lexem> currentLexems = new ArrayList<Lexem>();
		List<Operation> commands = new ArrayList<Operation>();
		while (lexems.size() > 0) {
			if (lexems.get(0).kind == LexemKind.COMMA) {
				commands.add(parseCommand(CurrentLexems));
				
			}
		}
	}
}
