import java.util.concurrent.atomic.AtomicInteger;

public class PhilosopherToken extends Thread {
    static AtomicInteger token = new AtomicInteger(0);
    static int count = 0;
    private final int id;
    public final Fork left;
    public final Fork right;

    public PhilosopherToken(int id, Fork f1, Fork f2, int count) {
        this.id = id;
        this.left = f1;
        this.right = f2;
        this.count = count;
    }

    @Override
    public void run() {
            int hasEaten = 0;
            do
                if (token.get() == id) {
                    System.out.println("Philosopher " + id + " is trying to pick up forks " + left.id + " and " + right.id);
                    left.take();
                    right.take();
                    System.out.println("Philosopher " + id + " is eating");
                    hasEaten++;
                    token.set((id + 2) % count);
                    left.put();
                    right.put();
                    System.out.println("Philosopher " + id + " puts down forks " + left.id + " and " + right.id);
                } while (hasEaten != count);
    }
}
