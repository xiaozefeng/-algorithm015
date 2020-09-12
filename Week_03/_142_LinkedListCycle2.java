package org.mickey.homework.week3;

import org.mickey.homework.week2.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mickey
 * @date 2020/9/11 11:51
 */
public class _142_LinkedListCycle2 {


    public ListNode hashSolution(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;
    }


    // 1. 先判断是否又环， 如果没有， 直接返回
    // 2. 如果有环，找到入口
    // 官方称 Floyd 算法
    public ListNode twoPointerSolution(ListNode head) {
        // phase1
        ListNode metingNode = findMetingNode(head);
        if (metingNode == null) return null;

        // phase2
        // 第一个节点指向头部， 第二次节点指向相遇点
        // 一起移动，相遇时，这个节点就是环的入口
        ListNode part1 = head;
        ListNode part2 = metingNode;
        while (part1 != part2) {
            part1 = part1.next;
            part2 = part2.next;
        }
        return part2;
    }

    private ListNode findMetingNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return walker;
        }
        return null;
    }
}
