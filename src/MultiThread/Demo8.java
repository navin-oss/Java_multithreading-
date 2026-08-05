package MultiThread;

public class Demo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(() -> Counter3.increament());
		
		Thread t2= new Thread(() -> Counter3.increament());

		
		t1.start();
		t2.start();
		

	}

}

class Counter3 {
	
	static int count = 0 ;
	
	static void increament() {
		synchronized(Counter3.class) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		count++;
		System.out.println(count);
	}
}}