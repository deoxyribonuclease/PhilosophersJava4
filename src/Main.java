public class Main {
    public static void main(String[] args) throws InterruptedException {

        int count = 5;
        Fork[] forks = new Fork[count];
        PhilosopherSeenWant[] philosophers = new PhilosopherSeenWant[count];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i);
        }
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new PhilosopherSeenWant(i, forks[i], forks[((i + 1) % philosophers.length)],count);
            philosophers[i].start();
        }
    }
}