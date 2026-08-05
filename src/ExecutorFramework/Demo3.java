package ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
//		try {
//		executor.execute(() -> {
//			int x = 10 / 0 ; 
//		});
//		}
//		catch(Exception e){
//			System.out.println("Execute exception...");
//		}
//		
		Future<Integer> f1 = executor.submit(() -> {
			return (10 / 0) ;
		});
		
		try {
			System.out.println(f1.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Catch the submit() exception...");
		}
		
	}

}
