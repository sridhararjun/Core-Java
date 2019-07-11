import java.util.LinkedList;

/**
 * 
 */

/**
 * @author Sribi
 *
 */
public class ProducerConsumerProblemMainClass {

	/*
	 * To avoid polling, Java uses three methods, namely, wait(), notify() and
	 * notifyAll(). All these methods belong to object class as final so that all
	 * classes have them. They must be used within a synchronized block only.
	 * 
	 * wait()-It tells the calling thread to give up the lock and go to sleep until
	 * some other thread enters the same monitor and calls notify(). 
	 * 
	 * notify()-It wakes up one single thread that called wait() on the same object. It should
	 * be noted that calling notify() does not actually give up a lock on a
	 * resource. 
	 * 
	 * notifyAll()-It wakes up all the threads that called wait() on the
	 * same object.
	 * 
	 */

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		final ClassToBeUsedByPC pc = new ClassToBeUsedByPC();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.Produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Producer Thread");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.Consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Consumer Thread");

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.Consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Consumer Thread T3");

		// Start both the threads now
		t1.start();
		t2.start();
		t3.start();

		// Logically, the producer thread must first complete
		t1.join();
		t2.join();
		t3.join();
	}

	public static class ClassToBeUsedByPC {

		LinkedList<Integer> integersList = new LinkedList<>();
		int capacity = 2;

		public void Produce() throws InterruptedException {
			int value = 0;

			while (true) {

				synchronized (this) {
					while (integersList.size() == capacity) {
						wait();
					}

					System.out.println("Producer started to produce now. And it produced - " + value);
					integersList.add(value++);

					// Notifies the consumer thread that it has produced something now
					notify();

					Thread.sleep(1000);
				}

			}

		}

		public void Consumer() throws InterruptedException {
			while (true) {
				/*
				 * Here this refers to the (outerclass.innerclass) The synchronized creates a monitor
				 * region here and starts the lock between thread access
				 * 
				 * 
				 */
				synchronized (this) {

					while (integersList.size() == 0) {
						wait();
					}

					System.out.println(Thread.currentThread().getName() + " Consumer started to consumer.It consumed - "
							+ integersList.removeFirst());
					// Notifies the producer thread that the list now has a free space
					notify();

					Thread.sleep(2000);

				}
			}
		}

	}

}
