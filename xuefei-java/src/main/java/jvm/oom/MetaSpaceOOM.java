package jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 11:35 上午
 * @Version 1.0
 */
public class MetaSpaceOOM {

    // 测试内存溢出的对象类
    public static class OomObject{}

    public static void main(String[] args){
        // 调用测试元数据空间OOM的方法
        MetaSpaceOOM(args);
    }

    /**
     *  测试运行时常量池OOM的方法
     * JVM启动参数：-XX:PermSize=10M -XX:MaxPermSize=10M
     * 适用版本：JDK1.6及之前
     */
    public static void RuntimeConstantPoolOOM(){
        // 使用List保持着常量池的引用，避免Full GC回收常量池
        List<String> list = new ArrayList<>();
        // 10MB的PermSize在Integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    /**
     *  测试元数据空间OOM的方法
     *  JVM启动参数：-XX:MetaspaceSize=10M
     *               -XX:MaxMetaspaceSize=10M
     *               -XX:+HeapDumpOnOutOfMemoryError
     * */
    public static void MetaSpaceOOM(String[] args){
        while (true) {
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OomObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)
                    (o, method, objects, methodProxy)
                            -> methodProxy.invokeSuper(o,args));
            enhancer.create();
        }
    }




}
