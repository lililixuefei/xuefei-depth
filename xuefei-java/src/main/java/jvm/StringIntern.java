package jvm;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/10/18 21:38
 * @Version 1.0
 */
public class StringIntern {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        String str2 = new StringBuilder("hello").append("world").toString();

        System.out.println(str1.intern() == str1);
        System.out.println(str2.intern() == str2);


        String str3 = "nihao";
        String str4 = "shijie";
    }
}
