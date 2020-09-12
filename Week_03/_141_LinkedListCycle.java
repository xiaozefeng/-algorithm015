package org.mickey.homework.week3;

import org.mickey.homework.week2.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mickey
 * @date 2020/9/11 11:38
 */
public class _141_LinkedListCycle {


    // Use HashSet
    public boolean useExtraSpace(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }

    // 快慢指针
    // 快指针一次走两步
    // 慢指针一次走一步
    // 无环情况：快指针会走到尾部
    // 有环情况， a和b两个跑圈，a跑的快， b跑的慢， 一定会相遇
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode walker = head;
        ListNode runner = head.next;
        while (walker != runner) {
            if (runner == null || runner.next == null) return false;
            walker = walker.next;
            runner = runner.next.next;
        }
        return true;
    }



}
