
public class Demo2 {

	
	//Thread id and name 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
	System.out.println("0th thread id :" + Thread.currentThread().getId());	
	System.out.println("0th thread name : " + Thread.currentThread().getName());
         Thread t1 = new Thread(() -> {
        	           
        	        System.out.println("1st Thread id :"+Thread.currentThread().getId());
        	        System.out.println("1st Thread name :"+Thread.currentThread().getName());
        	        } );
         
         Thread t2 = new Thread(() -> {
	           
 	        System.out.println("2nd Thread id: :" + Thread.currentThread().getId());
 	        System.out.println("2nd Thread name : " +Thread.currentThread().getName());
 	        } );
         
         t1.start();
         t2.start();
	}

}
