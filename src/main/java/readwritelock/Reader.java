package readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class Reader implements Runnable {
    private Number number;
    private ReadWriteLock lock;

    Reader(Number number, ReadWriteLock lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.readLock().lock();
            System.out.println("查詢數字: " + number.getNum());
            lock.readLock().unlock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
