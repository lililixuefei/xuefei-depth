package labuladong.binarytree.bst;

import labuladong.binarytree.TreeNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/20 2:53 PM
 * @Version 1.0
 */
public class InsertIntoBST {

    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) {
            return new TreeNode(val);
        }
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
