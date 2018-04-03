package com.dima.func.compiled;

/**
 * Представление константы
 */
public class OperationPower implements Operation {
	private final Operation operation1;
	private final Operation operation2;
	
	public OperationPower(Operation operation1, Operation operation2) {
		this.operation1 = operation1;
		this.operation2 = operation2;
	}
	
	@Override
	public Object execute(EngineContext context) {
		float val1 = OperationHelper.floatVal(operation1, context);
		float val2 = OperationHelper.floatVal(operation2, context);
		return Math.pow(val1, val2);
	}
	
	@Override
	public String toString() {
		return "OperationPower{" +
				"operation1=" + operation1 +
				", operation2=" + operation2 +
				'}';
	}
}
