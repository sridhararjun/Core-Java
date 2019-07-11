package com.java8.sridhar.LambdaExpressions;

public class Sample {
/*
 * Important aspects of a method
 * 1)Name 					 -- Anonymous
 * 			2)Parameter List -- Required for Lambda Expression
 * 			3)Body			 -- Required for Lambda Expression
 * 4)Return Type			 -- Inferred
 * 
 * 
 * And Backward Compatibility is provided and that's where the beauty is.Rather than just saying 
 * that here is the new Lambda Expressions"TADAAA" now you can use it with new APIs,The mentioned
 * here is the Lambda,go use it with existing APIs
 * Please find the below Example
 * GOTO 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Lambda Expression is used in the existing thread constructor which takes in the runnable atrget
		 * 
		*/
		Thread thread = new Thread(() -> System.out.println("In another thread"));				
		thread.start();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 System.out.println("In another thread");
			}
		});				
		thread1.start();
		System.out.println("In Main Thread");
		System.out.println("In Main Thread");
		System.out.println("In Main Thread");
	}

}
