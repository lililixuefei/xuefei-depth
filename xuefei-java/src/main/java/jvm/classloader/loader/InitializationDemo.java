package jvm.classloader.loader;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/23 22:59
 * @Version 1.0
 */
public class InitializationDemo {

    public static void main(String[] args) {
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
        new Son();
    }

}

