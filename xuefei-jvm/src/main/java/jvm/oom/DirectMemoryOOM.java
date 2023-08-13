package jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 11:38 上午
 * @Version 1.0
 */
public class DirectMemoryOOM {


    public static void main(String[] args) {
        // 调用测试虚拟机栈OOM的方法
        DirectMemoryOOM();
    }

    /**
     * 测试直接内存OOM的方法
     * JVM启动参数：-Xmx10M -XX:MaxDirectMemorySize=10M
     */
    public static void DirectMemoryOOM() {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        while (true) {
            // 申请1MB的直接内存
            unsafe.allocateMemory(1024 * 1024);
        }
    }


}
