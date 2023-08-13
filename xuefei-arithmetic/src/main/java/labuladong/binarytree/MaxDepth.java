package labuladong.binarytree;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 11:13 AM
 * @Version 1.0
 */
public class MaxDepth {


    // 定义：输入根节点，返回这棵二叉树的最大深度
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        return Math.max(leftMax, rightMax) + 1;
    }

}
