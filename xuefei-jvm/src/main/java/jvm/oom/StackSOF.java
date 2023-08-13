package jvm.oom;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 11:30 上午
 * @Version 1.0
 */
public class StackSOF {

    /**
     * 测试虚拟机栈SOF的方法
     * JVM启动参数：-Xss128k
     */
    public static void VMStackSOF() {
        int stackLength = 1;
        stackLength++;
        VMStackSOF();
    }

    public static void main(String[] args) {
        // 调用测试虚拟机栈SOF的方法
        VMStackSOF();
    }



}
