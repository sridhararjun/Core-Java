package com.java8.sridhar.defaultMethods;

 interface One {

	public void add(String a);

	default void show() {
		System.out.println("Printed from One");
	}

}
