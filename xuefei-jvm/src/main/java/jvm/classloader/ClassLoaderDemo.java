package jvm.classloader;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/2 8:19 下午
 * @Version 1.0
 */
public class ClassLoaderDemo extends ClassLoader {

    public static void main(String[] args) {
        ClassLoaderDemo classLoader = new ClassLoaderDemo();

        System.out.println("自定义加载器：" + classLoader);
        System.out.println("自定义加载器的父类加载器：" + classLoader.getParent());
        System.out.println("Java程序系统默认的加载器：" + ClassLoader.getSystemClassLoader());
        System.out.println("系统类加载器的父加载器：" + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("拓展类加载器的父加载器：" + ClassLoader.getSystemClassLoader().getParent().getParent());
    }

}
