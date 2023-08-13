package daily.spi;

/**
 * @Description
 * @Author xuefei
 * @Date 2022/11/16 10:32 AM
 * @Version 1.0
 */
public class MysqlStorage implements DataStorage {

    @Override
    public String search(String key) {
        return "【Mysql】搜索" + key + "，结果：No";
    }

}
