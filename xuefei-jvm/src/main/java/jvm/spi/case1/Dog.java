package jvm.spi.case1;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/3 10:33 上午
 * @Version 1.0
 */
public class Dog implements IShout {

    @Override
    public void shout() {
        System.out.println("wang wang");
    }

}
