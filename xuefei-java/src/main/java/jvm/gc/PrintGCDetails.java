package jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://juejin.cn/post/7075258758196101156
 * @Author xuefei
 * @Date 2023/3/10 10:42 上午
 * @Version 1.0
 */
// 启动参数：-Xms8M -Xmx8M -XX:+PrintGCDetails
public class PrintGCDetails {

    // 作为GC Roots
    static List<Object> listObject = new ArrayList<>();

    // 往新生代空间中填充对象
    static void newObject() {
        for (int i = 0; i <= 100000; i++) {
            new Object();
        }
    }

    // 创建的对象与GCRoots保持引用，足以对象晋升年老代空间
    static void oldObject() {
        for (int i = 0; i <= 10000; i++) {
            listObject.add(new Object());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            newObject();
            oldObject();
        }
    }
}

