package org.mickey.homework.week1;

/**
 * @author mickey
 * @date 8/28/20 23:23
 */
public class _21_MergeTowSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // define dummy head node
        ListNode dummyHead = new ListNode(-1);
        ListNode swimmingNode = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                swimmingNode.next = l1;
                l1 = l1.next;
            } else {
                swimmingNode.next = l2;
                l2 = l2.next;
            }
            swimmingNode = swimmingNode.next;
        }

        swimmingNode.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

    public ListNode mergeTowSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTowSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTowSortedLists(l1, l2.next);
            return l2;
        }
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}