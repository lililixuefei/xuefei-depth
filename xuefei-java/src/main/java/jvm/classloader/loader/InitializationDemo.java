package jvm.classloader.loader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/23 22:59
 * @Version 1.0
 */
public class InitializationDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        AtomicReference<BigDecimal> atomicReference = new AtomicReference<>();
        BigDecimal bigDecimal = new BigDecimal(100);
        BigDecimal bigDecimal2 = new BigDecimal(200);
        atomicReference.set(bigDecimal);
        System.out.println(atomicReference.compareAndSet(bigDecimal, bigDecimal2));

        System.out.println(atomicReference.get());
        System.out.println(bigDecimal);

        // 爷爷在静态代码块
        // 爸爸在静态代码块
        // 爸爸的岁数:25
//        System.out.println("爸爸的岁数:" + Son.factor);    //入口


        // 爷爷在静态代码块
        // 爸爸在静态代码块
        // 儿子在静态代码块
        // 我是爷爷~
        // 我是爸爸~
        // 我是儿子~
//        new Son();

//        new Son("2");
    }

}

