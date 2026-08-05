package CompatableFuture;

import java.util.concurrent.CompletableFuture;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompletableFuture<Integer> f1 = 
			CompletableFuture.supplyAsync(() -> 10);
		
		CompletableFuture<Integer> f2 = 
				CompletableFuture.supplyAsync(() -> 20);
		
		CompletableFuture<Void> result = 
				f1.thenCombine(f2 , (a , b) -> a + b)
				                 .thenAccept(r -> System.out.println(r));
		
	}

}
