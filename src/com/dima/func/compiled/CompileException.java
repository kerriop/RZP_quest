package com.dima.func.compiled;

import com.dima.func.parser.Lexem;
import java.util.List;

/**
 * Ошибка, возникающая при разборе пропаршенных лексем на синтаксические операции
 */
public class CompileException extends Exception {
	
	/**
	 * Создать строку описания ошибки со списком лексем через запятую
	 * @param s сообщение
	 * @param lexems список лексем
	 */
	public static String constructMessage(String s, List<Lexem> lexems) {
		StringBuilder stringBuilder = new StringBuilder(s);
		for (Lexem lexem : lexems) {
			stringBuilder.append(lexem.kind).append(", ");
		}
		return stringBuilder.toString();
	}
	
	public CompileException() {
	}
	
	public CompileException(String s) {
		super(s);
	}
	
	public CompileException(String s, Throwable throwable) {
		super(s, throwable);
	}
	
	public CompileException(Throwable throwable) {
		super(throwable);
	}
	
	public CompileException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1);
	}
}
