package org.mickey.homework.week2;

/**
 * @author mickey
 * @date 2020/9/1 15:52
 */
public class _21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if( l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }


    public ListNode mergeTwoListsUsingIterate(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 != null ? l1 : l2;
        return dummyNode.next;
    }

}
