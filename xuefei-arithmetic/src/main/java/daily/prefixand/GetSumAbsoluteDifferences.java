package daily.prefixand;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/21 12:43 PM
 * @Version 1.0
 */
public class GetSumAbsoluteDifferences {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        //计算前缀和
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] += nums[i];
        }
        //计算每个数的差绝对值之和
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // int sumOfLeftDifferences = (i+1)*nums[i]-prefixSum[i];
            // int sumOfRightDifferences = prefixSum[nums.length-1]-prefixSum[i]-nums[i]*(nums.length-1-i);
            // sumOfDifferences =  sumOfLeftDifferences+sumOfRightDifferences;
            output[i] = (i + 1) * nums[i] - prefixSum[i] + prefixSum[nums.length - 1] - prefixSum[i] - nums[i] * (nums.length - 1 - i);
        }
        return output;
    }
}
