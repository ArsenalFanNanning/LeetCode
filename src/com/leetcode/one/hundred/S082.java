package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2023-04-30 06:41
 * @Description: 删除排序链表中的重复元素 II -中等
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * 82. Remove Duplicates from Sorted List II
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class S082 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(2);
        ListNode l15 = new ListNode(3);
        head.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

}
