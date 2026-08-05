package CompatableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		CompletableFuture<Integer> f1 =
//				CompletableFuture.supplyAsync(() -> 10)
//		        .thenApply(result -> result * 2)
//		        .thenApply(result -> result * 3);
		
//		CompletableFuture<Void> f1 = 
//				CompletableFuture.supplyAsync(() -> 10)
//				.thenAccept(result -> System.out.println(result));
//		
		CompletableFuture<Void> f1 = 
				CompletableFuture.supplyAsync(() -> 10)
				.thenRun(() -> System.out.println("done"));
		
//
//		 try {
//			System.out.println(f1.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
