package jvm.spi.case2;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/3 10:36 上午
 * @Version 1.0
 */
public class RedisStorage implements DataStorage {

    @Override
    public String search(String key) {
        return "【Redis】搜索" + key + "，结果：Yes";
    }

}
