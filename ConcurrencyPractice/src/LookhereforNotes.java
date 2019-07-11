
public class LookhereforNotes {
	/*
	 * 
	 * 1. If we extend the Thread class, our class cannot extend any other class
	 * because Java doesn’t support multiple inheritance. But, if we implement the
	 * Runnable interface, our class can still extend other base classes.
	 * 
	 * 2. We can achieve basic functionality of a thread by extending Thread class
	 * because it provides some inbuilt methods like yield(), interrupt() etc. that
	 * are not available in Runnable interface.
	 * 
	 * Multithreading: Java allows concurrent execution of parts of a program,each
	 * following a seperate path of execution.This is called Multithreading
	 * 
	 * Main Thread: When a Java program starts,this is the first thread to start and
	 * the last thread to finish on completion of program.This is where from which
	 * all the other child threads are spawned.
	 * 
	 * Reference to Main Thread: This is done by calling the currentThread() on the
	 * Thread class.The default priority of main thread is 5 and the priorities of
	 * user threads are inherited from parent to child
	 * 
	 * SO,WHAT HAPPENS? when the program starts,JVM starts a main thread which looks
	 * for a main() method,and if once found it initializes the class.
	 * 
	 */

	public static void main(String[] args) {

		try {
			System.out.println("Deadlock is going to happen in this main thread now");
			// This line tells the main thread to wait for itself to die
			Thread.currentThread().join();
			System.out
					.println("This statement will never execute since the main thread entered into the deadlock state");
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		t.setName("Main Thread");
		t.setPriority(Thread.MAX_PRIORITY);

		ChildThread childThread = new ChildThread();
		System.out.println(childThread.getName());
		System.out.println(childThread.getPriority());
		childThread.setPriority(Thread.MIN_PRIORITY);
		childThread.setName("Child Thread");
		childThread.start();

	}

}
