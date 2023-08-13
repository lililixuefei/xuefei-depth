package clover.slidingwindow;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/17 11:46 上午
 * @Version 1.0
 */
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int maxLen = 0;
        int left = 0;// 窗口左边界
        int right = 0;// 窗口右边界
        int cost = 0;// 字符串转换的开销
        while (right < length) {
            // 累加绝对值
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            // 窗口中的元素开销太大，不满足条件，缩小窗口
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;// 缩小窗口
            }
            // 记录窗口最大值
            maxLen = Math.max(maxLen, right - left + 1);
            right++;// // 窗口右指针往右移
        }
        return maxLen;
    }

}
