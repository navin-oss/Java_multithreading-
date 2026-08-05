
public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		
		 System.out.println("Main Thread starts..");
		
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("Main Thread ends....");
		 
	}

}
