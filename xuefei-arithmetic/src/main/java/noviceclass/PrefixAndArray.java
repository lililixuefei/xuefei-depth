package noviceclass;

import java.util.Arrays;


/**
 * @Description
 * @Author xuefei
 * @Date 2023/1/29 3:48 PM
 * @Version 1.0
 */
public class PrefixAndArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] prefixAndArray = prefixAndArray(array);
        Arrays.stream(prefixAndArray).forEach(System.out::println);
    }

    public static int[] prefixAndArray(int[] array) {
        int[] prefixAndArray = new int[array.length + 1];

        int prefixAnd = 0;
        for (int i = 1; i < array.length + 1; i++) {
            prefixAndArray[i] = (prefixAnd += array[i - 1]);
        }
        return prefixAndArray;
    }
}
