package xiongmao.createthread;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:30
 * @Version 1.0
 */
public class ExtendsThread extends Thread {

	@Override
	public void run() {
		System.out.println("1......");
	}

	public static void main(String[] args) {
		new ExtendsThread().start();
	}

}

