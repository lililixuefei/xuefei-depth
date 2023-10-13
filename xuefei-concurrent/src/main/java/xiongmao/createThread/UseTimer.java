package xiongmao.createThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/12 23:34
 * @Version 1.0
 */
public class UseTimer {

	public static void main(String[] args) {
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("9......");
			}
		}, 0, 1000);
	}

}

