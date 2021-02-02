package com.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//To Invoke Lambda expression Functional interface is mandatory.
// Functional Interface acts as a TYPE for lambda expression.
/**
 * 
 * @author Rituraj Kumar
 *
 */
public class LambdaBasicOpeartions {
	public static void main(String[] args) {

		Functional func = () -> { System.out.println("Hello");};
		func.f1();

		func = () ->  System.out.println("Hello");
		func.f1();

		FunctionalAdditionDemo fadd = (int a, int b) -> { System.out.println(a+b); };
		fadd.f1(5, 10);
		
		fadd = (a,b) -> { System.out.println(a+b); }; //Compiler TYPE Inference
		fadd.f1(5, 10);
		
		FunctionalStringDemo fsdemo = (String s) -> { return s.length();};
		System.out.println(fsdemo.f1("hello"));
		
		fsdemo =  s -> s.length();
		System.out.println(fsdemo.f1("hello"));
		
		Runnable r = () -> {
			for(int i = 0; i<10; i++) {
				System.out.println("Child Thread");
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		for(int i = 0; i<10; i++) {
			System.out.println("Main Thread");
		}
		
		// Lambda Expression with Collection Sorting
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(5);
		al.add(2);
		al.add(50);
		al.add(100);
		Collections.sort(al);
		System.out.println("Default sorting in Ascending Order "+ al);
		Collections.sort(al, new myComparator());
		System.out.println("Custom sorting in Descending Order "+ al);
		
		Collections.sort(al, (o1,o2) -> (o1>o2)? -1 : (o1<o2)? 1 : 0);
		System.out.println("sorting through Lambda Expression " + al);
		
		//TreeSet example
		
		//TreeMap Example
		
		Employee emp1 = new Employee(500, "sunny");
		Employee emp2 = new Employee(100, "vunny");
		Employee emp3 = new Employee(300, "tunny");
		Employee emp4 = new Employee(900, "munny");
		Employee emp5 = new Employee(400, "runny");
		Employee emp6 = new Employee(200, "junny");
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(emp1);employees.add(emp2);
		employees.add(emp3);employees.add(emp4);
		employees.add(emp5);employees.add(emp6);
		Collections.sort(employees, (e1,e2) -> (e1.employeeId>e2.employeeId)? -1 :(e1.employeeId<e2.employeeId)? 1 : 0);
		System.out.println("Sorting of employee object "+ employees);
	}
}

@FunctionalInterface
interface Functional {
void f1();
}

@FunctionalInterface
interface FunctionalAdditionDemo {
void f1(int a , int b);
}

@FunctionalInterface
interface FunctionalStringDemo {
int f1(String s);
}

class myComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return (o1 > 02)? -1 : (o1 < 02)? 1 : 0 ;
	}
	
}

class Employee{
	public Integer employeeId;
	public String employeeName;
	
	public Employee(Integer employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
	
}