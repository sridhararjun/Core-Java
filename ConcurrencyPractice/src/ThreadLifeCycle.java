/**
 * 
 */

/**
 * @author Sribi
 *
 */
public class ThreadLifeCycle implements Runnable {

	/**
	 * Mutex - Mutual Exclusion Object:
	 * 
	 * So what is mutex? Mutex is logically a part of the Object's header data on
	 * the heap memory.All the objects in the JVM has this mutex(also called lock)
	 * which is used by other programs to share the access on something,be it
	 * accessing a file.So, when a thread tries to access an object, its mutex is
	 * locked which makes the object unavailable for other program threads.Once the
	 * lock is released, a new thread will lock it and the process continues. When a
	 * program is started, a mutex for a given resource is created at the beginning
	 * by requesting it from the system which in turn responds back with a unique
	 * name/id.If the mutex is already locked, a thread needing the resource is
	 * queued by the system until the lock is released on the mutex
	 * 
	 * If a thread wants to access an object's instance variables it has to obtain a
	 * lock on the object first.This is done by setting a flag(maybe) in the lock's
	 * memory area.A thread can obtain any number of locks on the same object, but
	 * has to release it the same number of times to release the object out of lock.
	 * 
	 * In Java, lock is obtained on an object by using the synchronized keyword or
	 * wait() or notify()
	 * ------------------------------------------------------------------------------
	 * In the Java virtual machine, every object and class is logically associated
	 * with a monitor. To implement the mutual exclusion capability of monitors, a
	 * lock (sometimes called a mutex) is associated with each object and class.
	 * This is called a semaphore in operating systems books, mutex is a binary
	 * semaphore.
	 * 
	 * If one thread owns a lock on some data, then no others can obtain that lock
	 * until the thread that owns the lock releases it. It would be not convenient
	 * if we need to write a semaphore all the time when we do multi-threading
	 * programming. Luckily, we don't need to since JVM does that for us
	 * automatically.
	 * 
	 * To claim a monitor region which means data not accessible by more than one
	 * thread, Java provide synchronized statements and synchronized methods. Once
	 * the code is embedded with synchronized keyword, it is a monitor region. The
	 * locks are implemented in the background automatically by JVM. Life cycle of
	 * thread:
	 * 
	 * https://www.programcreek.com/2011/12/monitors-java-synchronization-mechanism/
	 * 
	 * 
	 * -----------------------------------------------------------------------------
	 * 
	 * Refer for LifeCycle of Threads:
	 * 
	 * https://www.geeksforgeeks.org/lifecycle-and-states-of-a-thread-in-java/
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new ThreadLifeCycle());
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread is started");
		try {
			Thread.currentThread().wait();
			Thread.currentThread().notify();
			System.out.println("Waiting");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
