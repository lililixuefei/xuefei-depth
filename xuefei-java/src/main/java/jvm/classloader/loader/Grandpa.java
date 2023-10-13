package jvm.classloader.loader;


import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/23 22:55
 * @Version 1.0
 */
class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");

    }

    public Grandpa() {
        System.out.println("我是爷爷~");
    }
}

class Father extends Grandpa {
    static {
        System.out.println("爸爸在静态代码块");
    }

    public static int factor = 25;

    public Father() {
        System.out.println("我是爸爸~");
    }

    public Father(String name) {
        System.out.println("我是爸爸2~");
    }
}

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son() {
        System.out.println("我是儿子~");
    }

    public Son(String name) {
        System.out.println("我是儿子2~");
    }
}

