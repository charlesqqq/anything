package readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        Number number = new Number();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Reader reader = new Reader(number, lock);
        Writer writer = new Writer(number, lock);
        new Thread(reader).start();
        new Thread(writer).start();
    }
}
