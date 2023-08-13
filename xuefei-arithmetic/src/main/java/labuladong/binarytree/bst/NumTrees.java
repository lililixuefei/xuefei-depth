package labuladong.binarytree.bst;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/20 3:03 PM
 * @Version 1.0
 */
public class NumTrees {

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(9));
        System.out.println(numTrees.numTrees2(9));
    }

    // 备忘录
    int[][] memo;

    int numTrees2(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        return count2(1, n);
    }

    int count2(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count2(lo, mid - 1);
            int right = count2(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }

    /* 主函数 */
    int numTrees(int n) {
        // 计算闭区间 [1, n] 组成的 BST 个数
        return count(1, n);
    }

    /* 计算闭区间 [lo, hi] 组成的 BST 个数 */
    int count(int lo, int hi) {
        // base case
        if (lo >= hi) {
            return 1;
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i 的值作为根节点 root
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }

        return res;
    }
}
