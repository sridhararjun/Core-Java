package com.java8.sridhar.defaultMethods;

public abstract class ClassAbstract {

	public abstract void display();
	
	public void project() {
		System.out.println("Now Projecting");
	}
	
	static void staticdisplay(){
		System.out.println("static block");
	}
	
}
