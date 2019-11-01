package com.atecher.algorithms.leetcode;

import lombok.Data;

/**
 * @description:
 * @author: hanhongwei
 * @date: 2019-05-27 22:02
 * @link:https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        int sum = l1.val + l2.val + carry;
        ListNode result = new ListNode(sum % 10);
        carry = sum / 10;
        if (l1.next == null && l2.next != null) {
            result.next = processNode(l2.next, carry);
        } else if (l1.next != null && l2.next == null) {
            result.next = processNode(l1.next, carry);
        } else if (l1.next != null && l2.next != null) {
            result.next = addTwoNumbers(l1.next, l2.next, carry);
        } else if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return result;
    }

    private ListNode processNode(ListNode node, int carry) {
        int sum = node.val + carry;
        carry = sum / 10;
        node.val = sum % 10;
        if (node.next != null) {
            if (carry > 0) {
                ListNode listNode = processNode(node.next, carry);
                node.next = listNode;
            }
        } else if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return node;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(6);
        l1.next.next.next.next = new ListNode(7);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        new AddTwoNumbers().addTwoNumbers(l1, l2);

    }


    @Data
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
