package com.dima.func.compiled;

import com.dima.func.parser.Lexem;
import com.dima.func.parser.LexemKind;
import com.dima.func.parser.LexemParser;
import jdk.nashorn.internal.runtime.ParserException;

import java.util.ArrayList;
import java.util.List;

public class OperationParser {
	
	/**
	 * Парсит аргументы функции, разделённые запятыми
	 * @param brace скобки, внутри которых аргументы
	 * @return список пропаршенных аргументов
	 */
	private static List<Operation> parseFunctionArgs(Lexem brace) throws CompileException {
		List<Lexem> lexems = brace.childs;
		List<Lexem> currentLexems = new ArrayList<Lexem>();
		List<Operation> commands = new ArrayList<Operation>();
		while (lexems.size() > 0) {
			if (lexems.get(0).kind == LexemKind.COMMA) {
				commands.add(parseCommand(currentLexems));
				currentLexems.clear();
				lexems.remove(0);
			} else {
				currentLexems.add(lexems.get(0));
				lexems.remove(0);
			}
		}
		if (currentLexems.size() > 0) {
			commands.add(parseCommand(currentLexems));
			currentLexems.clear();
		}
		return commands;
	}
	
	private static Operation parsePrimitive(List<Lexem> lexems) throws CompileException {
		if (lexems.size() == 0)
			return null;
		
		LexemKind kind = lexems.get(0).kind;
		if (kind == LexemKind.BRACE && lexems.size() == 1) {
			return parseCommand(lexems.get(0).childs);
		} else if (kind == LexemKind.NUMBER && lexems.size() == 1) {
			return new OperationNumeric(Float.parseFloat(lexems.get(0).value));
		} else if (kind == LexemKind.VARIABLE) {
			return new OperationVariable(lexems.get(0).value);
		}
		throw new CompileException(CompileException.constructMessage(
				"Неизвестный синтаксический примитив! ",
				lexems
		));
	}
	
	private static Operation parseCommandPart(List<Lexem> lexems, int level) throws CompileException {
		if (level >= 4)
			return parsePrimitive(lexems);
		
		int count = 1;
		ArrayList<ArrayList<Lexem>> list = new ArrayList<>();
		LexemKind compareKind = LexemKind.UNKNOWN;
		ArrayList<Lexem> buffer = new ArrayList<Lexem>();
		for (Lexem lexem : lexems) {
			if (level == 0) {
				if (lexem.kind == LexemKind.PLUS) {
					count++;
					list.add(buffer);
					buffer = new ArrayList<>();
					continue;
				}
			} else if (level == 1) {
				if (lexem.kind == LexemKind.MINUS) {
					count++;
					list.add(buffer);
					buffer = new ArrayList<Lexem>();
					continue;
				}
			} else if (level == 2) {
				if (lexem.kind == LexemKind.MULTIPLY) {
					count++;
					list.add(buffer);
					buffer = new ArrayList<Lexem>();
					continue;
				}
			} else if (level == 3) {
				if (lexem.kind == LexemKind.DIVIDE) {
					count++;
					list.add(buffer);
					buffer = new ArrayList<Lexem>();
					continue;
				}
			}
			buffer.add(lexem);
		}
		
		if (count == 1) {
			return parseCommandPart(buffer, level + 1);
		} else {
			list.add(buffer);
			if (level == 0) {
				OperationMath compound = new OperationMath(LexemKind.PLUS);
				for (List<Lexem> sub : list)
					compound.addBlock(parseCommandPart(sub, level + 1));
				return compound;
			} else if (level == 1) {
				OperationMath compound = new OperationMath(LexemKind.MINUS);
				for (List<Lexem> sub : list)
					compound.addBlock(parseCommandPart(sub, level + 1));
				return compound;
			} else if (level == 2) {
				OperationMath compound = new OperationMath(LexemKind.MULTIPLY);
				for (List<Lexem> sub : list)
					compound.addBlock(parseCommandPart(sub, level + 1));
				return compound;
			} else if (level == 3) {
				OperationMath compound = new OperationMath(LexemKind.DIVIDE);
				for (List<Lexem> sub : list)
					compound.addBlock(parseCommandPart(sub, level + 1));
				return compound;
			}
		}
		
		return null;
	}
	
	/**
	 * Пропарсить целую команду
	 * @param lexems лексемы команды
	 */
	private static Operation parseCommand(List<Lexem> lexems) throws CompileException {
		if (lexems.size() == 0)
			return null;
		
		return parseCommandPart(lexems, 0);
	}
	
	/**
	 * Главная функция
	 * @return
	 */
	public static Operation parse(String expression) throws ParserException, CompileException {
		LexemParser lexemParser = new LexemParser(expression);
		return parseCommand(lexemParser.lexems);
	}
	
}