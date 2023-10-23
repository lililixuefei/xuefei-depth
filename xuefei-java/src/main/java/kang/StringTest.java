package kang;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/18 22:08
 * @Version 1.0
 */
public class StringTest {


    @Test
    public void test3(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        /**
         * 如下的s1 +
         */
        String s4 = s1 +s2;
        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)) ; // true
    }

}
