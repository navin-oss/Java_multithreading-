package ThreadCommunication;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Boxx box = new Boxx();
		
		Thread t1 = new Thread(() -> {
			for(int i = 0 ; i < 20 ; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					box.producer(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i = 0 ; i < 20 ; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					box.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
			
    
	}

}

class Boxx{
	volatile Integer item ;
	volatile boolean flag = false ;
	
	synchronized  void producer(int value) throws InterruptedException {
		while(flag == true){
			wait();
		}
		item = value ;
		flag = true ;
		System.out.println("Producer produces :" + value);
		notify();
	}
	
	synchronized void consumer() throws InterruptedException {
		while(flag == false) {
			wait();
		}
		System.out.println("Consumer consumes :" + item );
		item = null ;
		flag = false ;
		notify();
	}
}
