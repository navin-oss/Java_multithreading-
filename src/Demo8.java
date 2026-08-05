
public class Demo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Thread t1 = new Thread(() -> {
			 for(int i = 1  ; i <= 100 ; i++) {
				 if(i % 2 == 0) {
					 System.out.println("T1 : " + i);
					 Thread.yield();   
				 }
			 }
		 });
		 
			//1 to 100 odd nos
		 Thread t2 = new Thread(() -> {
			 for(int i = 1  ; i <= 100 ; i++) {
				 if(i % 2 != 0) {
					 System.out.println("T2 : " + i);
				 }
			 }
		 });
		 
		 t1.start();
		 t2.start();
	}

}
