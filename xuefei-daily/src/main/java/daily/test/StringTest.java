package daily.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author xuefei
 * @Date 2022/11/29 10:43 AM
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) {

        String a = "\uD83D\uDE01小冉超过";

        for (int i = 0; i < a.length(); i++) {
            System.out.println(a.charAt(i));
        }

        System.out.println(a.charAt(0));

    }

    private static String buildUserNickName(String nickName) {
        if (StringUtils.isBlank(nickName)) {
            return nickName;
        }
        int length = nickName.length();
        Character firstCharacter = nickName.charAt(0);
        nickName = length<=2 ? firstCharacter +"*" : firstCharacter+"**";
        return nickName;
    }
}
