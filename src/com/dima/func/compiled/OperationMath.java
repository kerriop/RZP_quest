package com.dima.func.compiled;

import com.dima.func.parser.LexemKind;

import java.util.ArrayList;
import java.util.List;

public class OperationMath implements Operation {
	private final LexemKind type;
	private List<Operation> blocks;
	
	public OperationMath(LexemKind type) {
		this.type = type;
		this.blocks = new ArrayList<>();
	}
	
	public void addBlock(Operation operation) {
		blocks.add(operation);
	}
	
	@Override
	public Object execute(EngineContext context) {
		if (blocks.size() == 0)
			return 0;
		
		float result = OperationHelper.floatVal(blocks.get(0), context);
		for (int i = 1; i < blocks.size(); i++) {
			float temp = OperationHelper.floatVal(blocks.get(i), context);
			switch (type) {
				case PLUS:
					result += temp;
					break;
				case MULTIPLY:
					result *= temp;
					break;
				case DIVIDE:
					result /= temp;
					break;
				case MINUS:
					result -= temp;
					break;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "OperationMath{" +
				"type=" + type +
				", blocks=" + blocks +
				'}';
	}
}
