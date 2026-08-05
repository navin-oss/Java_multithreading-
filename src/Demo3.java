
public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Thread t1 = new Thread(() -> {
	           
// 	        System.out.println("Thread id :"+Thread.currentThread().getId());
 	        System.out.println(" Thread name :"+Thread.currentThread().getName());
 	        } );
		 
		t1.start();
		t1.start();
		
		 //t1.run();

	}

}
