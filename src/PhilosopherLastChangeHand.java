public class PhilosopherLastChangeHand extends Thread {
    static int count = 0;
    private final int id;
    public final Fork left;
    public final Fork right;

    public PhilosopherLastChangeHand(int id, Fork f1, Fork f2,int count) {
        this.id = id;
        this.left = (f1.id< f2.id) ? f1 : f2;
        this.right = (f1.id< f2.id) ? f2 : f1;
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
       }while (hasEaten != count);
    }
}
