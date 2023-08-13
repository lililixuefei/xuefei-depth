package clover.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/22 10:21 上午
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                window.put(c, window.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
