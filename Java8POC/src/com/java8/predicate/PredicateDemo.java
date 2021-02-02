package com.java8.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @FunctionalInterface 
 * interface Predicate<T>{ 
 * 	public Boolean test(T t);
 * 	or()
 * 	and()
 * 	negate()
 * 	public static Boolean isEqual(T t);
 * }
 * 
 * 
 * @author Rituraj Kumar
 *
 */
public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(10));
		System.out.println(p.test(20));
		//System.out.println(p.test("abc"));
		
		Predicate<String> ps = s -> s.length() > 5;
		System.out.println(ps.test("nwbkcjcbl"));
		System.out.println(ps.test("abc"));

		//Predicate Joining
		int[] arr = {5,10,15,20,25,30,35,40,45,50};
		Predicate<Integer> pgt10 = i -> i > 10;
		Predicate<Integer> peven = i -> i % 2 == 0;
		System.out.println("Numbers greater than 10 are ");
		print(pgt10, arr);
		System.out.println("even numbers are ");
		print(peven, arr);
		System.out.println("numbers not greater than 10");
		print(pgt10.negate(), arr);
		System.out.println("Numbers greater than 10 and even are ");
		print(pgt10.and(peven), arr);
		System.out.println("Numbers greater than 10 or even are ");
		print(pgt10.or(peven), arr);
		
		String[] names = {"dcnj", "karu", "kjjhh", "yuoew", "kajal"};
		Predicate<String> nameStartsWithK = s -> s.startsWith("k");
		for (String s : names) {
			if(nameStartsWithK.test(s)) {
				System.out.println(s);
			}
		}
		
		Predicate<String> str = Predicate.isEqual("Rituraj");
		System.out.println(str.test("Rituraj"));
		System.out.println(str.test("abc"));
		
		//BiPredicates takes two input parameters
		BiPredicate<Integer, Integer> biPred = (a, b) -> (a+b) % 2 == 0;
		System.out.println(biPred.test(10, 20));
	}
	
	public static void print(Predicate<Integer> p, int[] arr) {
		for(int i : arr) {
			if(p.test(i)) {
				System.out.println(i);
			}
		}
	}
}
