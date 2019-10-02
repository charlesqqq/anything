package readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class Writer implements Runnable {
    private Number number;
    private ReadWriteLock lock;

    Writer(Number number, ReadWriteLock lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.writeLock().lock();
            System.out.println("現在的數字: " + number.getNum());
            number.setNum(number.getNum() - 1000);
            System.out.println("現在的數字減1000: " + number.getNum());
            lock.writeLock().unlock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
