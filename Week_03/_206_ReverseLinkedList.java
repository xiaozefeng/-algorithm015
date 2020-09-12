package org.mickey.homework.week3;

import org.mickey.homework.week2.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mickey
 * @date 9/10/20 23:52
 */
public class _206_ReverseLinkedList {

    // use a stack to reverse
    public ListNode useExtraSpace(ListNode head) {
        if (head == null || head.next == null) return head;
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (!stack.isEmpty()) {
            pre.next = new ListNode(stack.pop());
            pre = pre.next;
        }
        return dummy.next;
    }


    // Iteration
    // 参考 https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
    // 有动画演示， 比官方的更易懂
    public ListNode twoPointerSolution(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 参考 https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
    // cur 节点是一直到链表地步，有一点dfs的意思，最后返回的也是这个节点
    // head.next.next = head; 把当前节点的下一个节点的下一个节点指向自己， 看起来很绕，其实就是反转指向，并且要把head.next =null ，否则会形成环
    public ListNode reverseList(ListNode head) {
        return recursionSolution(head);
    }

    public ListNode recursionSolution(ListNode head) {
        // terminator
        if (head == null || head.next == null) return head;


        // trill down
        ListNode cur = recursionSolution(head.next);

        // process logic
        head.next.next = head;
        head.next = null;

        // reverse state
        return cur;
    }


}
