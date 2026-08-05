package MultiThread;

public class demo2 {
	
	static volatile boolean flag = false ;

	public static void main(String[] args) {
	
		
		
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			flag = true ;
		});
		
		Thread t2 = new Thread(() -> {
			while(!flag) {
				//System.out.println("Thread 2 running.......");
				//do nothing
			}
			System.out.println("Thread 2 is finished...");
		}) ;
		
		t1.start();
		t2.start();
		
		

	}

}
