package labuladong.binarytree.bst;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/20 2:44 PM
 * @Version 1.0
 */
public class ConvertBST {

    TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    // 记录累加和
    int sum = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化成累加树
        root.val = sum;
        traverse(root.left);
    }
}
