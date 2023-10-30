package xiongmao.createthread;

import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:33
 * @Version 1.0
 */
public class UseFutureTask {

	public static void main(String[] args) {
		FutureTask<String> futureTask = new FutureTask<>(() -> {
			System.out.println("7......");
			return "zhuZi";
		});
		new Thread(futureTask).start();
	}

}

