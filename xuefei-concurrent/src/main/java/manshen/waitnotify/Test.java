package manshen.waitnotify;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/08/31 17:24
 */
@Slf4j(topic = "c.Test")
public class Test {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        myThread.start();

        Thread.sleep(200);

    }


    static class MyThread extends Thread {

        @Override
        public void run() {
            log.debug("MyThread run");
        }
    }
}
