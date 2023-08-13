package labuladong.binarytree;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 2:28 PM
 * @Version 1.0
 */
public class ConnectTree {

    // 二叉树遍历函数 - 错误的
    void traverse(TreeNode root) {
        if (root == null || root.left == null) {
            return;
        }
        // 把左子节点的 next 指针指向右子节点
        root.left.next = root.right;

        traverse(root.left);
        traverse(root.right);
    }

    // 主函数
    TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }


    // 三叉树遍历框架
    void traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        node1.next = node2;

        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }
}
