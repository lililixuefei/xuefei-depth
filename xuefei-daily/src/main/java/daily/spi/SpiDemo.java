package daily.spi;

import java.util.ServiceLoader;

/**
 * @Description
 * @Author xuefei
 * @Date 2022/11/16 10:35 AM
 * @Version 1.0
 */
public class SpiDemo {

    public static void main(String[] args) {

        ServiceLoader<DataStorage> serviceLoader = ServiceLoader.load(DataStorage.class);
        System.out.println("============ Java SPI 测试 ============");
        serviceLoader.forEach(loader -> System.out.println(loader.search("Yes Or No")));

    }

}
