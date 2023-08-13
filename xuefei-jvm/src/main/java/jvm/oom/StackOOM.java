package jvm.oom;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 11:30 上午
 * @Version 1.0
 */
public class StackOOM {


    // ！！！慎重运行，大多数情况下会导致OS假死！！！
    public static void main(String[] args) {
        // 调用测试虚拟机栈OOM的方法
        VMStackOOM();
    }


    /**
     * 测试虚拟机栈OOM的方法
     * JVM启动参数：-Xss1M
     */
    public static void VMStackOOM() {
        for (; ; ) {
            new Thread(() -> {
                while (1 == 1) {
                }
            }).start();
        }
    }


}
