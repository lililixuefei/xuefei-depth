package daily.spi;

/**
 * @Description
 * @Author xuefei
 * @Date 2022/11/16 10:33 AM
 * @Version 1.0
 */
public class RedisStorage implements DataStorage {

    @Override
    public String search(String key) {
        return "【Redis】搜索" + key + "，结果：Yes";
    }

}

