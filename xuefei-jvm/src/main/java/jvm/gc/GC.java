package jvm.gc;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/10 10:40 上午
 * @Version 1.0
 */
// 启动参数：-Xms8M -Xmx8M -XX:+PrintGC
public class GC {
    static void newObject(){
        for (int i = 0; i <= 10000; i++) {
            new Object();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (;;){
            newObject();
        }
    }
}
