package com.atguigu.linkedlist;

/**
 * @ author He
 * @ create 2022-03-23 11:50
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode prove = head;
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prove.next = list1;
                list1 = list1.next;
            } else {
                prove.next = list2;
                list2 = list2.next;
            }
            prove=prove.next;
        }
        prove.next = list1 == null ? list2 : list1;

        return head.next;
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