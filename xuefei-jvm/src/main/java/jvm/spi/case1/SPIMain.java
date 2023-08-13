package jvm.spi.case1;

import java.util.ServiceLoader;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/3 10:34 上午
 * @Version 1.0
 */
public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }

}
