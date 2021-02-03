package com.java8.methodreference;

/**
 * Method Reference is another way of functional interface representation.
 * and this is alternative of Lambda expression.
 *
 *  Note- For Method Reference Argument(only method params not return type, not modifier and not also method name) must be same.
 *
 * @author Rituraj Kumar
 *
 */
public class MethodRefrenceDemo {

    public MethodRefrenceDemo(){
        System.out.println("constructor execution using method reference");
    }

	public static void main(String[] args) {

	    // Functional Interface Implemenattion using Lambda Expression
        MethodReferenceInterface methodReferenceInterface = () -> System.out.println("Lambda exp implementation");
        methodReferenceInterface.m2();

        //Functional Interface Implementation using Method reference
        MethodReferenceInterface methodReferenceInterface2 = MethodRefrenceDemo::m1;
        methodReferenceInterface2.m2();

        //Functional Interface Implementation using Method reference
        MethodRefrenceDemo methodRefrenceDemo = new MethodRefrenceDemo();
        MethodReferenceInterface methodReferenceInterface3 = methodRefrenceDemo::m3;
        methodReferenceInterface3.m2();

        Runnable r = methodRefrenceDemo::run;
        Thread t = new Thread(r);
        t.start();
        for (int i =0; i<=10; i++){
            System.out.println("Main Thread..");
        }

        //Method reference using constructor
        MRForConstructor mrForConstructor = MethodRefrenceDemo::new;
        mrForConstructor.getInstance();
    }

	public static void m1() {
        System.out.println("Method Reference Implementation for static method");
    }

    public void m3() {
        System.out.println("Method Reference Implementation for instance method");
    }

    public void run(){
	    for (int i =0; i<=10; i++){
            System.out.println("Child Thread running using method reference implementation");
        }
    }
}

@FunctionalInterface
interface MethodReferenceInterface{
    public void m2();
}

@FunctionalInterface
interface MRForConstructor{
    public MethodRefrenceDemo getInstance();
}