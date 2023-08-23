package jvm.classloader.loader;

/**
 * https://juejin.cn/post/7102219703891787784
 *
 * @Description
 * @Author xuefei
 * @Date 2023/8/23 22:52
 * @Version 1.0
 */
public class Book {

    public static void main(String[] args) {
//        System.out.println("Hello Liu Baoshuai");
        System.out.println("Hello Liu Baoshuai" + new Book().price);

    }

    Book() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    {
        System.out.println("书的普通代码块");
    }

    int price = 110;

    static {
        System.out.println("书的静态代码块");
    }

    static int amount = 112;

}

