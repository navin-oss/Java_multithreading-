package VirtualThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread t1 = Thread.startVirtualThread(() -> {
//			System.out.println(Thread.currentThread() + " thread start..");
//		});
//       
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
		
		for(int i = 0 ; i <= 5 ; i++) {
			executor.submit(() -> {
				System.out.println("Tak executed by   " + Thread.currentThread());
			});
			
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
		
	}

}
