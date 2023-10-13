package xiongmao.createThread;

import java.util.concurrent.*;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:32
 * @Version 1.0
 */
public class UseExecutorService {

	public static void main(String[] args) {
		ExecutorService poolA = Executors.newFixedThreadPool(2);
		poolA.execute(() -> {
			System.out.println("4A......");
		});
		poolA.shutdown();

		// 又或者自定义线程池
		ThreadPoolExecutor poolB = new ThreadPoolExecutor(2, 3, 0,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		poolB.submit(() -> {
			System.out.println("4B......");
		});
		poolB.shutdown();
	}

}

