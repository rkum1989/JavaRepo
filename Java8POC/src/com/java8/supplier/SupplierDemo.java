package com.java8.supplier;

import java.util.Date;
import java.util.function.Supplier;

/**
 * interface Supplier<R>{ // R is return type
 * 	R get(); //only method no default and no static method available
 * }
 * @author Rituraj Kumar
 *
 */
public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<Date> sup = () -> new Date();
		System.out.println(sup.get());
		
		//No BiSupplire because it doesn't take any input
	}

}
