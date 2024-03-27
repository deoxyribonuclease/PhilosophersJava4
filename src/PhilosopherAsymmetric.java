
public class PhilosopherAsymmetric extends Thread {
    static int count = 0;
    private final int id;
    public final Fork left;
    public final Fork right;

    public PhilosopherAsymmetric(int id, Fork f1, Fork f2, int count) {
        this.id = id;
        this.left = (this.id % 2 == 0) ? f1 : f2;
        this.right = (this.id % 2 == 0) ? f2 : f1;
        this.count = count;
    }

    @Override
    public void run() {
    int hasEaten = 0;
      do {
        System.out.println("Philosopher " + id + " is trying to pick up forks " + left.id + " and " + right.id);
        left.take();
        right.take();
        hasEaten++;
        System.out.println("Philosopher " + id + " is eating");
        left.put();
        right.put();
        System.out.println("Philosopher " + id + " puts down forks " + left.id + " and " + right.id);
       } while (hasEaten != count);
    }
}