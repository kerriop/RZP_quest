package com.dima.func.compiled;

import java.util.List;

/**
 * Оперирование функциями после получения контекста
 */
public class OperationFunction implements Operation {
	private final String functionName;
	private final List<Operation> braces;
	
	public OperationFunction(String functionName, List<Operation> braces) {
		this.functionName = functionName;
		this.braces = braces;
	}
	
	@Override
	public Object execute(EngineContext context) {
		Object[] args = new Object[braces.size()];
		for (int i = 0; i < args.length; i++) {
			args[i] = braces.get(i).execute(context);
		}
		return context.executeFunction(functionName, args);
	}
	
	@Override
	public String toString() {
		return "OperationFunction{" +
				"functionName='" + functionName + '\'' +
				", braces=" + braces +
				'}';
	}
}
