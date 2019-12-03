import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class SemaphoreSlowTask {

    private static ReentrantLock lock = new ReentrantLock(true);

    static class SlowTask implements Runnable {
        volatile int value = 0;
        private Semaphore semaphore;

        public SlowTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        public void run() {
            semaphore.acquireUninterruptibly();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("value = " + value);
                    Thread.sleep(1 * 1000);
                    value += 10;
                }
            }
            catch (Exception e) {}
            finally {
                semaphore.release();
            }
        }
    }

    private static void accessResource() {
        lock.lock();
        try {
            int value = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println("value = " + value);
                Thread.sleep(1000);
                value += 10;
            }
        }
        catch (Exception e) {}
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*Semaphore sLock = new Semaphore(3);

        ExecutorService service = Executors.newFixedThreadPool(10);
        IntStream.of(100).forEach(i -> service.execute(new SlowTask(sLock)));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);*/

        Thread t1 = new Thread(() -> {accessResource();}); t1.start();
        Thread t2 = new Thread(() -> {accessResource();}); t2.start();
        Thread t3 = new Thread(() -> {accessResource();}); t3.start();
        Thread t4 = new Thread(() -> {accessResource();}); t4.start();
    }
}
