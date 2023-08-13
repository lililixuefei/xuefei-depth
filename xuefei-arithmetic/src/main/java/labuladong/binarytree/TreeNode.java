package labuladong.binarytree;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 11:14 AM
 * @Version 1.0
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode next;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
