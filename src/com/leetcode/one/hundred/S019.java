package com.leetcode.one.hundred;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Arsenal
 * @Date: 2022-12-12 23:46
 * @Description: 删除链表的倒数第 N 个结点-中等
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * Follow up: Could you do this in one pass?
 */
public class S019 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(8);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(6);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(4);
        ListNode l17 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        //System.out.println(removeNthFromEnd(l1, 2));
        // System.out.println(removeNthFromEndStack(l1, 2));
        System.out.println(removeNthFromEndTwoPoints(l1, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public static ListNode removeNthFromEndStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static ListNode removeNthFromEndTwoPoints(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
