package com.dima.func.compiled;

/**
 * Представление константы
 */
public class OperationNumeric implements Operation {
	private final float value;
	
	public OperationNumeric(float value) {
		this.value = value;
	}
	
	@Override
	public Object execute(EngineContext context) { return value; }
	
	@Override
	public String toString() {
		return "OperationNumeric{" +
				"value=" + value +
				'}';
	}
}
