package locks;

import java.util.concurrent.locks.StampedLock;

public class Stampedlock {

    public static void main(String[] args) {

        Shareeesource sr = new Shareeesource();

        Thread t1 = new Thread(() -> sr.read(), "Reader-1");
        Thread t2 = new Thread(() -> sr.read(), "Reader-2");
        Thread t3 = new Thread(() -> sr.read(), "Reader-3");

        Thread t4 = new Thread(() -> sr.write(30), "Writer-1");
        Thread t5 = new Thread(() -> sr.write(40), "Writer-2");
        Thread t6 = new Thread(() -> sr.write(50), "Writer-3");

        t1.start();
        t2.start();
        t3.start();

        t4.start();
        t5.start();
        t6.start();
    }
}

class Shareeesource {

    private int value = 0;

    private final StampedLock lock = new StampedLock();

    public int read() {

        // Try optimistic read (no lock acquired)
        long stamp = lock.tryOptimisticRead();

        int currentValue = value;

        // Simulate some work while reading
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName()
                    + " was interrupted while reading.");
        }

        // Check if a writer modified the value
        if (!lock.validate(stamp)) {

            System.out.println(Thread.currentThread().getName()
                    + " optimistic read failed. Switching to read lock.");

            stamp = lock.readLock();

            try {
                currentValue = value;
            } finally {
                lock.unlockRead(stamp);
            }

        } else {
            System.out.println(Thread.currentThread().getName()
                    + " optimistic read succeeded.");
        }

        System.out.println(Thread.currentThread().getName()
                + " reads value = " + currentValue);

        return currentValue;
    }

    public void write(int newValue) {

        long stamp = lock.writeLock();

        try {

            System.out.println(Thread.currentThread().getName()
                    + " acquired WRITE lock.");

            Thread.sleep(2000);

            value = newValue;

            System.out.println(Thread.currentThread().getName()
                    + " updated value to " + value);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(Thread.currentThread().getName()
                    + " was interrupted while writing.");

        } finally {

            lock.unlockWrite(stamp);

            System.out.println(Thread.currentThread().getName()
                    + " released WRITE lock.");
        }
    }
}