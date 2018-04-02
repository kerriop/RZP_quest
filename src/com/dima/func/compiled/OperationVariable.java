package com.dima.func.compiled;

/**
 * Представление переменной
 */
public class OperationVariable implements Operation {
	private final String variableName;
	
	public OperationVariable(String variableName) {
		this.variableName = variableName;
	}
	
	@Override
	public Object execute(EngineContext context) {
		return context.get(variableName);
	}
	
	@Override
	public String toString() {
		return "OperationVariable{" +
				"variableName='" + variableName + '\'' +
				'}';
	}
}
