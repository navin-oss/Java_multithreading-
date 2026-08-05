package ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo2 {

	public static void main(String[] args) {
      
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Future<Integer> f1 = executor.submit(() -> {
			
			Thread.sleep(3000);
			
			return 10;
		});
		
		try {
			System.out.println(f1.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
