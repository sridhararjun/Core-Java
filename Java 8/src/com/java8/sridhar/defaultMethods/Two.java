package com.java8.sridhar.defaultMethods;


/**
 * @author Sribi
 *
 */
interface Two extends One {
	public void subtract();

	static void staticshow() {
		System.out.println("static show from Interface Two");
	}
	
	default void show() {
		System.out.println("Printed from Two");
	}
}
