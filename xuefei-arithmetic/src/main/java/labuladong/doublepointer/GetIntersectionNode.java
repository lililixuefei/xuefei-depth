package labuladong.doublepointer;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 10:23 上午
 * @Version 1.0
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode headA = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode headB = new ListNode(-1);
        headB.next = head2;
        getIntersectionNode(headA, headB);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

}
