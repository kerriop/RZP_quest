package com.dima.func.compiled;

/**
 * Единица языка в скомпилированном виде
 */
public interface Operation {
	
	/**
	 * Запуск операции
	 * @return результат выполнения
	 */
	Object execute(EngineContext context);
}