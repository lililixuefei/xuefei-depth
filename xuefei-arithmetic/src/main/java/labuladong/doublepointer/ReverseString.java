package labuladong.doublepointer;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/28 7:06 下午
 * @Version 1.0
 */
public class ReverseString {

    void reverseString(char[] s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length - 1;
        while (left < right) {
            // 交换 s[left] 和 s[right]
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
