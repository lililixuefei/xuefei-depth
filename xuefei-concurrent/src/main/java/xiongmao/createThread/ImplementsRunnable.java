package xiongmao.createThread;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:31
 * @Version 1.0
 */
public class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("2......");
	}

	public static void main(String[] args) {
		ImplementsRunnable runnable = new ImplementsRunnable();
		new Thread(runnable).start();
	}

}

