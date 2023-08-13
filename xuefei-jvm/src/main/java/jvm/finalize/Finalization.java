package jvm.finalize;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/3 11:35 上午
 * @Version 1.0
 */
public class Finalization {

    public static Finalization f;

    // 当对象被GC时，会在GC前调用finalize()方法执行
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("重新与GcRoots建立连接...");
        // 当执finalize方法时，重新将当前实例复活，让对象变成可触及性的
        f = this;
    }

    @Override
    public String toString() {
        return "我是Finalization实例对象....";
    }

    public static void main(String[] args) throws InterruptedException {
        f = new Finalization();
        // 置空引用(处于可复活状态)
        f = null;

        System.out.println("第一次GC被强制触发了....");
        // 手动触发GC
        System.gc();

        Thread.sleep(1000);
        if (f == null) {
            System.out.println("f == null");
        } else {
            System.out.println("f ！= null");
        }
        // 再次置空(前面复活过一次，这次为不可复活)
        f = null;
        System.out.println("第二次GC被强制触发了....");
        // 手动触发GC
        System.gc();

        Thread.sleep(1000);
        if (f == null) {
            System.out.println("f == null");
        } else {
            System.out.println("f ！= null");
        }
    }

}
