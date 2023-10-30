package xiongmao.createthread;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:33
 * @Version 1.0
 */
public class UseThreadGroup {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("groupName");

		new Thread(group, ()->{
			System.out.println("6-T1......");
		}, "T1").start();

		new Thread(group, ()->{
			System.out.println("6-T2......");
		}, "T2").start();

		new Thread(group, ()->{
			System.out.println("6-T3......");
		}, "T3").start();
	}

}

