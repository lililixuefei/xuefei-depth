package labuladong.doublepointer;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/28 7:07 下午
 * @Version 1.0
 */
public class IsPalindrome {

    boolean isPalindrome(String s) {
        // 一左一右两个指针相向而行
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
