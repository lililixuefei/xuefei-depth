package xiongmao.createthread;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:34
 * @Version 1.0
 */
public class UseAnonymousClass {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("8A......");
			}
		}).start();

		new Thread(() ->
				System.out.println("8B......")
		).start();
	}

}

