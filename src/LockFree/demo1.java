package LockFree;

import java.util.concurrent.atomic.AtomicInteger;

public class demo1 {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		Thread t1 = new Thread(() -> {
			for(int i = 1 ; i <= 10000 ; i++) {
				counter.increment();
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i = 1 ; i <= 10000 ; i++) {
				counter.increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(counter.count);

	}

}

//Atomic variable -> AtomicInteger
class Counter{
//	int count = 0 ;
	AtomicInteger count = new AtomicInteger(0);
	void increment() {
		count.incrementAndGet(); //++count
	}
}