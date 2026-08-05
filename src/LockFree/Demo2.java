package LockFree;

import java.util.concurrent.atomic.AtomicReference;

public class Demo2 {

	public static void main(String[] args) {
		
		SeatBooking sb = new SeatBooking();
		
		Thread t1 = new Thread(() -> {
			boolean value = sb.bookSeat("Navin");
			System.out.println("t1 says " + value);
			
		});
		Thread t2 = new Thread(() -> {
			boolean value = sb.bookSeat("Om");
			System.out.println("t2 says " + value);
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb.seat);
	}

}

class SeatBooking{
	
//	String seat = new String("EMPTY") ;
//yamule race condition yenar atomic refernce vapraych
	AtomicReference<String> seat = new AtomicReference<>("EMPTY");
//	
//	boolean bookSeat(String name) {
//		if(seat.equals("EMPTY")) {
//			
//			seat = new String(name);
//			return true ;
//		}
//		return false ;
//	}
	boolean bookSeat(String name) {
		String currentValue = seat.get();
		
		if(currentValue.equals("EMPTY") == false){
			return false;
		}
		
		
		return seat.compareAndSet("EMPTY", name);
		//first compafre and set name jr string empty asel trch new value
	}
	public void displaySeats() {
		// TODO Auto-generated method stub
		
	}
	
}
//Compare and Set