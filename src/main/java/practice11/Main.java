package practice11;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final static AtomicInteger totalSum = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            work(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum.get());
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        double result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static double doHardWork(int start, int count) {
        double a = 1;
        for (int i = 0; i < count; i++) {
            a += Math.cbrt(34.3415)*Math.exp(34.34524784)/Math.sqrt(a);
            totalSum.incrementAndGet();
        }
        return a;
    }
}
