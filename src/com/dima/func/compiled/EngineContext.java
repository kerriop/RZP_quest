package com.dima.func.compiled;

import java.util.HashMap;
import java.util.Map;

/**
 * Контекст выполнения мат выражений
 */
public class EngineContext {
	private Map<String, Object> variables = new HashMap<String, Object>();
	
	/**
	 * Получить значение переменной
	 * @param variableName название
	 * @return значение
	 */
	public Object get(String variableName) {
		return variables.get(variableName);
	}
	
	/**
	 * Установить значение переменной
	 * @param variableName название
	 * @param object значение
	 */
	public void set(String variableName, Object object) {
		variables.put(variableName, object);
	}
	
	/**
	 * Запуск функции
	 * @param functionName
	 * @param args
	 * @return
	 */
	public Object executeFunction(String functionName, Object[] args) {
		if (functionName.equals("sin")) {
			return Math.sin((float) args[0]);
		} else if (functionName.equals("cos")) {
			return Math.cos((float) args[0]);
		}
		else {
			return 2;
		}
	}
	
}
