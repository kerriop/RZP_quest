package com.dima.func.compiled;

public class OperationHelper {
	
	/**
	 * Получить числовое значение из любой operation
	 * @param operation операция
	 */
	public static float floatVal(Operation operation, EngineContext context) {
		Object object = operation.execute(context);
		if (object instanceof Float) {
			return (float) object;
		} else if (object instanceof Double) {
			return (float) (double) object;
		} else if (object instanceof Integer) {
			return (float) (int) object;
		} else {
			return Float.NaN;
		}
	}
	
}
