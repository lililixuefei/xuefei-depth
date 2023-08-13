package jvm.spi.case2;

import java.util.ServiceLoader;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/3 10:37 上午
 * @Version 1.0
 */
public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<DataStorage> serviceLoader = ServiceLoader.load(DataStorage.class);
        System.out.println("============ Java SPI 测试============");
        serviceLoader.forEach(loader -> System.out.println(loader.search("Yes Or No")));
    }

}
