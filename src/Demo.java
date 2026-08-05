
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyThread t1 = new MyThread();
//		t1.start();
	
		//MyRunnable t = new MyRunnable(); 
		Thread t1 = new Thread(() -> System.out.println("Thread is runninggg")) ;
		t1.start();
	}
}


class MyThread extends Thread{
	
   @Override
     public void run() {
	// TODO Auto-generated method stub
	   System.out.println("Thread is running");
	super.run();
    }
}

class MyRunnable implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Thread 2 is running ...");
	}
	
}