package manshen.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Semaphore;

import static manshen.util.Sleeper.sleep;


@Slf4j(topic = "c.TestSemaphore")
public class TestSemaphore {

    public static void main(String[] args) {
        // 1. 创建 semaphore 对象 用来限制能同时访问共享资源的线程上限
        Semaphore semaphore = new Semaphore(3);

        // 2. 10个线程同时运行
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    log.debug("running...");
                    sleep(new Random().nextInt(50));
                    log.debug("end...");
                } finally {
                    semaphore.release();
                }
            }).start();
        }

    }
}
