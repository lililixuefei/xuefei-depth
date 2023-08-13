package labuladong.monotonequeue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/1 4:26 PM
 * @Version 1.0
 */
public class MaxSlidingWindow {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7, 3};
        int[] res1 = maxSlidingWindow(nums, 3);
        int[] res2 = getMaxWindow(nums, 3);

        Arrays.stream(res1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(res2).forEach(System.out::print);
    }

    /* 解题函数的实现 */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res[j++] = (window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }



    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // qmax 窗口最大值的更新结构
        // 放下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
