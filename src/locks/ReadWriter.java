package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriter {

    public static void main(String[] args) {

        ShareResource sr = new ShareResource();

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

class ShareResource {

    private int value = 0;

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public int read() {

        readLock.lock();

        try {

            System.out.println(Thread.currentThread().getName()
                    + " acquired READ lock.");

            System.out.println(Thread.currentThread().getName()
                    + " is reading value = " + value);

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName()
                    + " finished reading.");

        
        } catch (InterruptedException e) {}
        
        finally {

            readLock.unlock();

            System.out.println(Thread.currentThread().getName()
                    + " released READ lock.");
        }
        return value;

    }

    public void write(int newValue) {

        writeLock.lock();

        try {

            System.out.println(Thread.currentThread().getName()
                    + " acquired WRITE lock.");

            Thread.sleep(2000);

            value = newValue;

            System.out.println(Thread.currentThread().getName()
                    + " updated value to " + value);

        } catch (InterruptedException e) {} 
        
        finally {

            writeLock.unlock();

            System.out.println(Thread.currentThread().getName()
                    + " released WRITE lock.");
        }
    }
}