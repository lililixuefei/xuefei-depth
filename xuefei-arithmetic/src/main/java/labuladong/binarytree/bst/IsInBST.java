package labuladong.binarytree.bst;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/20 2:52 PM
 * @Version 1.0
 */
public class IsInBST {

    boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return isInBST(root.right, target);
        } else {
            return isInBST(root.left, target);
        }
    }
}
