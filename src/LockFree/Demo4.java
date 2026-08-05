package LockFree;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class Demo4 {

	public static void main(String[] args) throws InterruptedException {

        SeatBookingg booking = new SeatBookingg();

        Thread t1 = new Thread(() -> booking.bookSeat(5, "Navin"));
        Thread t2 = new Thread(() -> booking.bookSeat(5, "Rahul"));
        Thread t3 = new Thread(() -> booking.bookSeat(10, "Amit"));

        t1.start();
        t2.start();
        t3.start();

       Thread.sleep(2000);

        System.out.println("\nSeat Status:");
        booking.displaySeats();

	}

}
class SeatBookingg {

    private AtomicReferenceArray<String> seats =
            new AtomicReferenceArray<>(20);

    public void bookSeat(int seatNo, String name) {

        if (seats.compareAndSet(seatNo, null, name)) {
            System.out.println(name + " booked Seat " + seatNo);
        } else {
            System.out.println(name + " failed. Seat " + seatNo +
                    " already booked by " + seats.get(seatNo));
        }
    }

    public void displaySeats() {
        for (int i = 0; i < seats.length(); i++) {
            System.out.println("Seat " + i + " : " + seats.get(i));
        }
    }
}