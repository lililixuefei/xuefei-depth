package labuladong.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/9 7:49 PM
 * @Version 1.0
 */
public class Traverse {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        traverse(nums, 0);
    }


    /* 递归遍历数组 */
    public static void traverse(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        // 前序位置
        traverse(arr, i + 1);
        // 后序位置
        System.out.println(i);
    }
}
