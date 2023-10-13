package xiongmao.synchronizeddemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/13 21:58
 * @Version 1.0
 */
public class ObjectHead {

    public static void main(String[] args) throws InterruptedException {
        /**
         无锁态：虚拟机刚启动时 new 出来的对象处于无锁状态
         **/
        Object obj = new Object();
        // 查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());


        /**
         匿名偏向锁：休眠4S后再创建出来的对象处于匿名偏向锁状态
         PS：当一个线程在执行被synchronized关键字修饰的代码或方法时，如果看到该锁
         对象是处于匿名偏向锁状态的（标志位为偏向锁但是对象头中MrakWord内threadID
         为空），那么这个线程将会利用cas机制把自己的线程ID设置到mrakword中，此后
         如果没有其他线程来竞争该锁，那么这个线程再执行被需要获取该锁的代码将不需
         要经过任何获取锁和释放锁的过程。
         **/
        Thread.sleep(4000);
        Object obj1 = new Object();
        System.out.println(ClassLayout.parseInstance(obj1).toPrintable());

        /**
         轻量级锁：对于真正的无锁态对象obj加锁之后的对象处于轻量级锁状态
         **/
        synchronized (obj) {
            // 查看对象内部信息
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }

        /**
         重量级锁：调用wait方法之后锁对象直接膨胀为重量级锁状态
         **/
        new Thread(() -> {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1);
        synchronized (obj) {
            // 查看对象内部信息
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

}

