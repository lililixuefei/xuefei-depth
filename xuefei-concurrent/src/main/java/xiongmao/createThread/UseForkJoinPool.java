package xiongmao.createThread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:34
 * @Version 1.0
 */
public class UseForkJoinPool {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.execute(() -> {
			System.out.println("10A......");
		});

		List<String> list = Arrays.asList("10B......");
		list.parallelStream().forEach(System.out::println);
	}
}

