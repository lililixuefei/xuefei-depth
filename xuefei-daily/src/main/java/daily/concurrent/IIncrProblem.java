package daily.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @author: xuefei
 * @date: 2022/10/14 10:15 AM
 */
public class IIncrProblem {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        incrProblem_Thread();
        incrProblem_ThreadPool();
    }


    private static void incrProblem_ThreadPool() throws InterruptedException, ExecutionException {
        IncrRunnable incrRunnable = new IncrRunnable();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);

        List<Future<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Void> future = (Future<Void>) fixedThreadPool.submit(incrRunnable);
            futures.add(future);
        }

        for (Future<Void> future : futures) {
            future.get();
        }
        fixedThreadPool.shutdown();

        System.out.println(incrRunnable.i);
        System.out.println(incrRunnable.fixI.get());

    }

    private static void incrProblem_Thread() throws InterruptedException {
        IncrRunnable incrRunnable = new IncrRunnable();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(incrRunnable, "Thread-" + i);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(incrRunnable.i);
        System.out.println(incrRunnable.fixI.get());
    }

    static class IncrRunnable implements Runnable {

        public int i = 0;

        public AtomicInteger fixI = new AtomicInteger(0);

        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                i++;
                fixI.incrementAndGet();
            }
        }
    }
}
