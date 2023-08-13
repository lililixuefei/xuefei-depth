package labuladong.doublepointer;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 10:18 上午
 * @Version 1.0
 */
public class FindFromEnd {

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }

}
