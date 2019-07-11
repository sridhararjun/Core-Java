package com.java8.sridhar.defaultMethods;
/**
 * 
 */

/**
 * @author Sribi
 *
 */
public class ExampleClass extends ClassAbstract implements One,Two{


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		One one = new One() {
			@Override
			public void add(String a) {
				// TODO Auto-generated method stub
				System.out.println(a);
			}
			
		};
		one.add("works" + One.class.getName());
		System.out.println(one.getClass()+" "+ClassAbstract.class.getName() );
		ClassAbstract.staticdisplay();
		Two.staticshow();
		new ExampleClass().show();
	}

	@Override
	public void add(String a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subtract() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Two.super.show();
	}
	
}
