package com.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *  interface Function<T,R>{ //T = input parameter type and R = Return type parameter
 * 	public abstract R apply(T t);
 *   f1.andThen(f2); // first f1 executed then f2
 *   f1.compose(f2); // first f2 then f1 executed
 *  public static F identity(); //returns same input as output
 * }
 * @author Rituraj Kumar
 *
 */
public class FunctionDemo {

	public static void main(String[] args) {
		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("rituraj"));
		
		//Function chaining
		Function<String, String> fupper = s -> s.toUpperCase();
		Function<String, String> frev = s -> {
			String str = "";
			for(int i = s.length()-1; i >= 0; i--) {
				str = str + s.charAt(i);
			}
			return str;
		};
		
		System.out.println(fupper.andThen(frev).apply("rituraj"));
		
		Function<Integer, Integer> fsum = i -> i+i;
		Function<Integer, Integer> fmult = i -> i*i*i;
		
		System.out.println(fsum.andThen(fmult).apply(2));
		System.out.println(fsum.compose(fmult).apply(2)); // first fmult then fsum executed
		
		Function<String, String> fid = Function.identity();
		System.out.println(fid.apply("Rituraj Kumar"));
		
		//BiFunction
		BiFunction<Integer, Integer, Integer> biFunc = (x, y) -> x*y;
		System.out.println("BiFunction "+ biFunc.apply(10, 20));
	}
}
