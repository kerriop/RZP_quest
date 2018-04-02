package com.dima;

import com.sun.corba.se.spi.orb.Operation;

public class Main {
	
	public static void main(String[] args) {
        Operation operation = OperationParser.parse("2 + x");
        EngineContext context = new EngineContext();
        for (int i = 0; i < 10; i++) {
        	context.set("x", i);
	        System.out.println(operation.execute(context));
        }
    }
}
