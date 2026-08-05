
public class Demo7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
	  System.out.println("Main Thread starts.");
	  
	  Thread t1 = new Thread(() -> {
		  
		  try {
			Thread.sleep(2000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  System.out.println("Thread 0 starts...");
	  });
	  
	  t1.start();
	  
	  t1.join(1000); //
	  
	  System.out.println("Main Thread ends ...");
	}

}
