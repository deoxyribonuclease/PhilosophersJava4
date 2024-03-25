import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    public final int id;
    private final ReentrantLock lock = new ReentrantLock();;

    public Fork(int id) {
        this.id = id;
    }
    public void take() {
        lock.lock();
    }
    public void put() {
        lock.unlock();
    }
    public boolean tryTake() {
        return lock.tryLock();
    }
}
