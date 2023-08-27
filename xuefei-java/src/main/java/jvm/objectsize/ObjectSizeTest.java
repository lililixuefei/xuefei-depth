package jvm.objectsize;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description: https://juejin.cn/post/7057538876830646286
 * @author: xuefei
 * @date: 2023/08/27 00:07
 */
public class ObjectSizeTest {

    public static class A {
        int i = 0;
        long l = 0L;
        Object obj = new Object();
    }

    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("-------------------");

        Object array = new int[9];
        System.out.println(ClassLayout.parseInstance(array).toPrintable());

        System.out.println("-------------------");


        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

}
