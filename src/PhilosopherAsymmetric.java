
public class PhilosopherAsymmetric extends Thread {
    static int count = 0;
    private final int id;
    public final Fork left;
    public final Fork right;

    public PhilosopherAsymmetric(int id, Fork f1, Fork f2, int count) {
        this.id = id;
        this.left = f1;
        this.right = f2;
        this.count = count;
    }

    @Override
    public void run() {
            for (int i = 0; i < count; i++) {
                System.out.println("Philosopher " + id + " is trying to pick up forks " + left.id + " and " + right.id);
                left.take();
                right.take();
                if(id % 2 == 0){
                    left.take(); right.take();}
                else{
                    right.take(); left.take();}
                System.out.println("Philosopher " + id + " is eating");
                left.put();
                right.put();
                System.out.println("Philosopher " + id + " puts down forks " + left.id + " and " + right.id);
            }
    }
}