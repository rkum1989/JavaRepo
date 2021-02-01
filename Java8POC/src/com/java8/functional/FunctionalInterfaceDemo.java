package com.java8.functional;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		FunctionalSquareRootExample fdemo = i -> i * i;
		System.out.println(fdemo.squareRoot(10));
	}

}

interface FunctionalSquareRootExample {
	public int squareRoot(int i);
}

@FunctionalInterface
interface Child extends FunctionalSquareRootExample {

}

@FunctionalInterface
interface Child2 extends FunctionalSquareRootExample {
	public int squareRoot(int i);
}

// Not a functional interface because this interface has 2 abstract methods.
// @FunctionalInterface
interface Child3 extends FunctionalSquareRootExample {
	public int squareRoot(String s);
}
