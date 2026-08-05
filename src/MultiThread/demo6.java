package MultiThread;

public class demo6 {

	public static void main(String[] args) throws InterruptedException {
		
		Counter2  c = new Counter2();
		
		Thread t1 = new Thread(() -> {
			
			for(int i = 0 ; i < 10000 ; i++) {
				c.increament();
			}
		});
		

		Thread t2 = new Thread(() -> {
			
			for(int i = 0 ; i < 10000 ; i++) {
				c.increament();
			}
		});
		
		
	     t1.start();
	     t2.start();
	     
	     t1.join();
	     t2.join();
	     
	     System.out.println(c.count);
	     
	    

	}

}

class Counter2{
	
	public int count = 0 ;
	
    public void increament() {
    	synchronized(this) {
		count++;
	}
   }
}