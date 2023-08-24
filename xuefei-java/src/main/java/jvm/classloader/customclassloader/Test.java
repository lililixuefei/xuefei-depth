package jvm.classloader.customclassloader;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/24 22:33
 * @Version 1.0
 */
public class Test {


    public static void main(String[] args) throws Exception {
        while (true) {
            run();
            Thread.sleep(1000);
        }
    }
    /**
     * ClassLoader用来加载class类文件的,实现类的热替换
     * 注意，需要在swap目录下，一层层建立目录com/tw/client/，然后将Foo.class放进去
     * @throws Exception
     */
    public static void run() throws Exception {
        CustomClassLoader customClassLoader = new CustomClassLoader("D:\\xuefei-work\\swap", new String[]{"jvm.classloader.customclassloader.Foo"});
        Class clazz = customClassLoader.loadClass("jvm.classloader.customclassloader.Foo");
        Object foo = clazz.newInstance();
        Method method = foo.getClass().getMethod("sayHello", new Class[]{});
        method.invoke(foo, new Object[]{});
    }

}
