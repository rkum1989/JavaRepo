package com.java8.staticdefault;

import java.util.function.Supplier;

public class DefaulableFactory {
	// Interfaces now allow static methods
	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}

}
