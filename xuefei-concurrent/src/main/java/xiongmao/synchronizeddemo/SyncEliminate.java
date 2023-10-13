package xiongmao.synchronizeddemo;

/**
 * https://juejin.cn/post/6977744582725681182#heading-19
 *
 * @Description
 * @Author xuefei
 * @Date 2023/10/13 22:02
 * @Version 1.0
 */
public class SyncEliminate {

    // 情况一：
    public void appendString(String s1, String s2) {
    /*
    StringBuffer是线程安全，由于sb只会在append方法中使用,不可能被其他线程引用
    因此sb属于不可能共享的资源,JVM会自动消除内部的锁
    */
        StringBuffer sb = new StringBuffer();
        sb.append(s1).append(s2);
    }

    // 情况二：
    StringBuffer sb = new StringBuffer();

    public synchronized void appendString2(String s1, String s2) {
    /*
    StringBuffer是线程安全，由于sb是在appendString方法中使用,而appendString
    是被synchronized修饰的，是线程安全的，那么没有必要再这里获取两把锁
    因此JVM会自动消除内部的锁，有些小伙伴看到这里会疑惑，这不是锁重入吗？
    其实并不是，锁重入指的是同一个锁资源被线程多次获取时直接跳过获取锁逻辑，稍后会分析
    */
        sb.append(s1).append(s2);
    }


}
