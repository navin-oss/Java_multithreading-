package ThreadCommunication;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box box = new Box();
		
		Thread t1 = new Thread(() -> {
			for(int i = 0 ; i < 20 ; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				box.producer(i);
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i = 0 ; i < 20 ; i++) {
				try {
					Thread.sleep(71);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				box.consumer();
			}
		});
		
		t1.start();
		t2.start();
			
    
	}

}

class Box{
	Integer item ;
	boolean flag = false ;
	
	void producer(int value) {
		item = value ;
		flag = true ;
		System.out.println("Producer produces :" + value);
	}
	
	void consumer() {
		System.out.println("Consumer consumes :" + item );
		item = null ;
		flag = false ;
	}
}
