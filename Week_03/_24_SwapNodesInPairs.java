package org.mickey.homework.week3;

import org.mickey.homework.week2.ListNode;

/**
 * @author mickey
 * @date 2020/9/11 11:30
 */
public class _24_SwapNodesInPairs {

    // Recursion
    public ListNode swapPairs(ListNode head) {
        // terminator
        if (head == null || head.next == null) return head;
        // process current level logic
        ListNode first = head;
        ListNode second = head.next;
        // trill down
        first.next = swapPairs(second.next);
        second.next = first;
        // reverse state
        return second;
    }

    // iteration
    public ListNode iterationSolution(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // swapping
            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            head = first.next;
        }

        return dummy.next;
    }


}
