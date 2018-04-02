package com.dima.func.compiled;

/**
 * Единица языка в скомпилированном виде
 */
public interface Operation {
	
	Object execute(EngineContext context);
}
