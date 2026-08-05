package LockFree;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LikeCounter likeCounter = new LikeCounter();
		
		Thread t1 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t2 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t3 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t4 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t5 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t6 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t7 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t8 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});

		Thread t9 = new Thread(() -> {
		    for (int i = 0; i < 10; i++) {
		        likeCounter.like();
		    }
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total Likes : " +likeCounter.total());
 }
}

class LikeCounter{
	
	//AtomicReference<Integer> totalCount = new AtomicReference<>(0);
	AtomicInteger totalCount = new AtomicInteger(0);
	public void like() {
		totalCount.incrementAndGet();
 //	Integer currentCount ;
//		Integer finalCount;
//		// totalCount.set(totalCount.get() + 1);//this cause race condition
//		while(true) {
//			//1.we will capture the latest value 
//			 currentCount = totalCount.get();
//			
//			//2.Incerement like by one 
//			 finalCount = currentCount + 1 ;
//			
//			//3.Check again , if the count is still what i saw
//			if(totalCount.compareAndSet(currentCount, finalCount)) {
//				return ;
//			}
//			//4.If a thread reaches here someone must update the counnter value
//		    //Re-try
//			System.out.println("Conflict Detected ...retrying");
//		}
//		
	}
	
	public int total() {
		return totalCount.get();
	}
}
