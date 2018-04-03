package com.dima.func;

import com.dima.func.compiled.CompileException;
import com.dima.func.compiled.EngineContext;
import com.dima.func.compiled.Operation;
import com.dima.func.compiled.OperationParser;
import com.dima.func.parser.ParserException;
import com.dima.func.visual.Interprier;

import java.sql.Array;

public class Main {
	
	public static void main(String[] args) throws CompileException {
//		Operation operation = OperationParser.parse("x + 2");
		EngineContext context = new EngineContext();
		
//		for (int i = 0; i < 5; i++) {
//			context.set("x", i);
//			System.out.println(operation.execute(context));
//		}
		
		new Interprier();
	}
}

