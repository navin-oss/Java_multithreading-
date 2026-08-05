package MultiThread;

public class Demo7 {
	
    public static void main(String[] args) {
    	Bank b1 = new Bank();
    	
//    	
//    	Thread t1 = new Thread(() -> b1.deposite());
//    	
//    	Thread t2 = new Thread(() -> b1.withdraw());
//    	
        Thread t1 = new Thread(() -> b1.m1());
    	
    	Thread t2 = new Thread(() -> b1.m1());
    	
    	t1.start();
    	t2.start();
    	
    }
}


class Bank{
	
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	void m1() {
		synchronized(new Object()) {
			System.out.println(Thread.currentThread().getName() + " Enter m1");
			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		}
	}
	
	 void deposite() {
		synchronized(lock1) {
		System.out.println("Deposite logic...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		 }
	}
	
	
	 void withdraw() {
		 synchronized(lock2) {
	System.out.println("withdraw logic...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 }
}