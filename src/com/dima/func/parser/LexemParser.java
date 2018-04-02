package com.dima.func.parser;

import jdk.nashorn.internal.runtime.ParserException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Ядро парсера
 */
public class LexemParser {
	private String source;
	private int offset;
	private int sourceLength;
	public List<Lexem> lexems;
	
	private Lexem htmlLexem;
	private int htmlInlineOpen;
	
	public LexemParser(String source) throws ParserException {
		this.source = source;
		
		this.sourceLength = source.length();
		
		List<Lexem> lexems = new ArrayList<>();
		parse(lexems);
		this.lexems = lexems;
	}
	
	/**
	 * Парсит последовательное выражение
	 * Рекурсивно по скобкам
	 * @param list список, куда записывать текущие лексемы
	 * @throws ParserException ошибка при парсере
	 */
	private void parse(List<Lexem> list) throws ParserException {
		LexemKind kind = LexemKind.UNKNOWN;
		LexemKind prevKind = LexemKind.UNKNOWN;
		
		while (offset < sourceLength) {
			//пропуск лишних символов (пробел, таб, новая строка, перенос каретки)
			char c = source.charAt(offset);
			while (offset < sourceLength && (c == ' ' || c == '\t' || c == '\r' || c == '\n')) {
				offset++;
				if (offset >= sourceLength)
					break;
				c = source.charAt(offset);
			}
			
			if (offset >= sourceLength || c == ')' || c == '}' || c == ']') {
				offset++;
				break;
			}
			
			Lexem lexem = parseStatic();
			if (lexem == null) {
				lexem = parseDynamic();
				if (lexem == null) {
					throw new ParserException(
							String.format(
									"Неизвестная лексема на позиции %d: %s",
									offset,
									source.substring(offset, offset + Math.min(30, sourceLength - offset))
							)
					);
				}
			}
			
			kind = lexem.kind;
			if (kind == LexemKind.BRACE) {
				List<Lexem> childs = new ArrayList<>();
				parse(childs);
				lexem.childs = childs;
			} else if (kind == LexemKind.NUMBER && prevKind == LexemKind.MINUS) {
				list.get(list.size() - 1).kind = LexemKind.PLUS;
				lexem.value = "-" + lexem.value;
			}
			
			list.add(lexem);
			prevKind = kind;
		}
	}
	
	/**
	 * Парсит статичную лексему на текущем offset
	 * @return лексему
	 */
	private Lexem parseStatic() {
		for (StaticLexemDefinition def : LexemDefinitions.statics) {
			String rep = def.representation;
			int len = rep.length();
			
			if (offset + len > sourceLength || !source.substring(offset, offset + len).equals(rep))
				continue;
			
			this.offset += len;
			
			Lexem lexem = new Lexem();
			lexem.kind = def.kind;
			lexem.offset = this.offset;
			lexem.length = len;
			lexem.value = def.representation;
			return lexem;
		}
		return null;
	}
	
	/**
	 * Парсит динамическую лексему на текущем offset
	 * @return
	 */
	private Lexem parseDynamic() {
		for (DynamicLexemDefinition def : LexemDefinitions.dynamics) {
			Matcher matcher = def.representation.matcher(source.substring(offset));
			if (!matcher.find())
				continue;
			
			String found = matcher.group(0);
			this.offset += found.length();
			
			Lexem lexem = new Lexem();
			lexem.offset = this.offset;
			lexem.length = found.length();
			lexem.value = found;
			lexem.kind = def.kind;
			return lexem;
		}
		return null;
	}
	
}