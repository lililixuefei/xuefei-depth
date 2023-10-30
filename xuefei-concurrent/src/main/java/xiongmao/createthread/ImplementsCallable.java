package xiongmao.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:31
 * @Version 1.0
 */
public class ImplementsCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("3......");
		return "zhuZi";
	}

	public static void main(String[] args) throws Exception {
		ImplementsCallable callable = new ImplementsCallable();
		FutureTask<String> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}

}

