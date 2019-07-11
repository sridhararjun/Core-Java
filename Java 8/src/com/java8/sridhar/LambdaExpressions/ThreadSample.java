/**
 * 
 */
package com.java8.sridhar.LambdaExpressions;

/**
 * @author Sribi
 *
 */
public class ThreadSample extends Thread {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread started");
		System.out.println(Thread.currentThread().getName());
	}
	ThreadSample(){
		System.out.println(Thread.currentThread().getName());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread thread = new Thread();
		ThreadSample thread = new ThreadSample();
		thread.start();
		
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("Started");
//	}

}
