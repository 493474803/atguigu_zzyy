import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Concorrent {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<>();

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.readLock().lock();

    }
}
