package jvm.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/08/27 16:20
 */
public class ReferenceType {

    public static void main(String[] args) {

        // 强引用
        Object obj = new Object();
        System.out.println("-------------");

        // 弱软引用
        SoftReference<HashMap> cacheSoftRef = new SoftReference<HashMap>(new HashMap<Object, Object>());
        cacheSoftRef.get().put("竹子", "熊猫");
        System.out.println(cacheSoftRef.get().get("竹子"));

        System.out.println("-------------");


        // 弱引用
        Student student = new Student(1, "xuefei", "男");
        WeakReference<Student> weakReference = new WeakReference<>(student);
        System.out.println("存在引用的弱引用对象(GC 前):" + weakReference.get());
        System.gc();
        System.out.println("存在引用的弱引用对象(GC 后):" + weakReference.get());

        System.out.println("-------------");

        WeakReference<Student> weakReference2 = new WeakReference<>(new Student(2, "xuefei2", "男"));
        System.out.println("存在引用的弱引用对象(GC 前):" + weakReference2.get());
        System.gc();
        System.out.println("存在引用的弱引用对象(GC 后):" + weakReference2.get());

    }

}
