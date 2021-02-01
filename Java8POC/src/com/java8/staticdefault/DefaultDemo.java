package com.java8.staticdefault;

public class DefaultDemo implements DefaultInter, DefaultInter2{

	public static void main(String[] args) {
		DefaultDemo defaultDemo = new DefaultDemo();
		defaultDemo.m1();
	}

	@Override
	public void m1() {
		System.out.println("own implementation");
		DefaultInter.super.m1();
		DefaultInter2.super.m1();
	}

}

interface DefaultInter{
	default public void m1() {
		System.out.println("default implementation 1");
	}
}

interface DefaultInter2{
	default public void m1() {
		System.out.println("default implementation 2");
	}
}