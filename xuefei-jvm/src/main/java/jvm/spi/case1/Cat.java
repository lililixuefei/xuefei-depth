package jvm.spi.case1;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/3 10:32 上午
 * @Version 1.0
 */
public class Cat implements IShout {

    @Override
    public void shout() {
        System.out.println("miao miao");
    }

}
