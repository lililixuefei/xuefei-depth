package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 11:24 上午
 * @Version 1.0
 */
public class HeapOOM {

    // 测试内存溢出的对象类
    public static class OomObject {
    }

    /**
     * 测试Java堆空间OOM的方法
     * JVM启动参数：-Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void HeapOOM() {
        List<OomObject> OOMlist = new ArrayList<>();
        // 死循环：反复往集合中添加对象实例
        for (; ; ) {
            OOMlist.add(new OomObject());
        }
    }

    public static void main(String[] args) {
        // 调用测试堆空间OOM的方法
        HeapOOM();
    }
}
