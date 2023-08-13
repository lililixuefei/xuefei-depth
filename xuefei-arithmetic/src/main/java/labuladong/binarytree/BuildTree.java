package labuladong.binarytree;

import java.util.HashMap;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 2:50 PM
 * @Version 1.0
 */
public class BuildTree {


    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    /**
     * 通过前序和中序遍历结果构造二叉树
     */
    TreeNode build1(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build1(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);

        root.right = build1(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }


    /**
     * 通过后序和中序遍历结果构造二叉树
     */
    TreeNode build2(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build2(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);

        root.right = build2(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    /**
     * 通过后序和前序遍历结果构造二叉树
     */
    TreeNode build3(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // root.left 的值是前序遍历第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int leftRootVal = preorder[preStart + 1];
        // leftRootVal 在后序遍历数组中的索引
        int index = valToIndex.get(leftRootVal);
        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = build3(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = build3(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);

        return root;
    }
}
