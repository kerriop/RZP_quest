package com.dima.func;

import com.dima.func.compiled.CompileException;
import com.dima.func.compiled.EngineContext;
import com.dima.func.compiled.Operation;
import com.dima.func.compiled.OperationParser;
import com.dima.func.parser.ParserException;

public class Main {
	
	public static void main(String[] args) throws ParserException, CompileException {
		Operation operation = OperationParser.parse("2 * x");
		EngineContext context = new EngineContext();

		for (int i = 0; i < 10; i++) {
			context.set("x", i);
			System.out.println(operation.execute(context));
		}
	}
}

