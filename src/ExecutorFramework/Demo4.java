package ExecutorFramework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
			    2,                 // core pool size
			    5,                 // maximum pool size
			    0L,
			    TimeUnit.SECONDS,
			    new ArrayBlockingQueue<>(2)
			);
     
		for(int i = 1 ; i <=5 ; i++) {
			int taskId = i ;
			
			executor.execute(() -> {
				System.out.println("Task " + taskId + " is performed by " + 
			       Thread.currentThread().getName());
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
		}
		
		executor.shutdown();
	}

}
