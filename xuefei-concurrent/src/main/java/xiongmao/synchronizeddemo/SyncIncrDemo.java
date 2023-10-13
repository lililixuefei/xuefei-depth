package xiongmao.synchronizeddemo;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/13 22:04
 * @Version 1.0
 */
public class SyncIncrDemo implements Runnable {
    //共享资源(临界资源)
    static int i = 0;

    //synchronized关键字修饰实例成员方法
    public synchronized void incr() {
        i++;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 1000; j++) {
                incr();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncIncrDemo syncIncrDemo = new SyncIncrDemo();
        Thread t1 = new Thread(syncIncrDemo);
        Thread t2 = new Thread(syncIncrDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

