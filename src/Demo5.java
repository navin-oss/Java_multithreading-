
public class Demo5 {

	public static void main(String[] args) {
		
		
		Thread mainThread = Thread.currentThread();
     
		
		//thread  new stage 
		Thread t = new Thread(() -> {
			 System.out.println("Name of current state : " + Thread.currentThread().getName());
			 System.out.println("Main Thread of current state : " + mainThread.getState());
		});
		
		System.out.println(t.getState());
		
		//runnable state 
		t.start();
		System.out.println(t.getState()); //runnable , terminated
		
		try {
			Thread.sleep(2009);
		} catch (InterruptedException e) { 
			
		 System.out.println("Name of current state : " + mainThread.getState());

		}
		
		System.out.println(t.getState());
	}

}
