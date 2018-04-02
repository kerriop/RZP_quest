package com.dima.func.parser;

/**
 * Описание одной выбранной лексемы
 * @param <T> тип, которым описывается её контент
 */
public class LexemDefinition<T> {
	public LexemKind kind;
	public T representation;
}