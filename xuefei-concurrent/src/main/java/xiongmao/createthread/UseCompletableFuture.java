package xiongmao.createthread;

import java.util.concurrent.CompletableFuture;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:32
 * @Version 1.0
 */
public class UseCompletableFuture {

	public static void main(String[] args) throws InterruptedException {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			System.out.println("5......");
			return "zhuZi";
		});
		// 需要阻塞，否则看不到结果
		Thread.sleep(1000);
	}

}

