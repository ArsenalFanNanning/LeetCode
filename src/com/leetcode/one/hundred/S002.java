package com.leetcode.one.hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Arsenal
 * @Date: 2022-11-22 00:06
 * @Description: 两数相加-中等
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class S002 {
    public static void main(String[] args) {
        //[9,9,9,9,9,9,9]
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(9);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        //[9,9,9,9]
        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        l2.next = l22;
        l22.next = l23;
        l23.next = l24;

        //ListNode listNode = violence(l1, l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode cur = listNode;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static ListNode violence(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        String num1 = "";
        while (cur != null) {
            num1 += cur.val;
            cur = cur.next;
        }

        cur = l2;
        String num2 = "";
        while (cur != null) {
            num2 += cur.val;
            cur = cur.next;
        }


        //System.out.println("num1=" + num1 + ",num2=" + num2);
        StringBuilder num = new StringBuilder();
        List<ListNode> nums = new ArrayList<>();
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.min(len1, len2);
        int r = 0;
        int carry = 0;
        //num1=942,num2=9465
        while (r < len) {
            char ch1 = num1.charAt(r);
            char ch2 = num2.charAt(r);
            int value = Character.getNumericValue(ch1) + Character.getNumericValue(ch2) + carry;
            if (value < 10) {
                carry = 0;
                num.append(value);
                nums.add(new ListNode(value));
            } else {
                num.append(value % 10);
                nums.add(new ListNode(value % 10));
                carry = 1;
            }
            r++;
        }

        if (len1 < len2) {
            while (r < len2) {
                int value = Character.getNumericValue(num2.charAt(r)) + carry;
                if (value < 10) {
                    num.append(value);
                    nums.add(new ListNode(value));
                    carry = 0;
                } else {
                    num.append(value % 10);
                    nums.add(new ListNode(value % 10));
                    carry = 1;
                }
                r++;
            }
            // 加最后一次的进位
            if (carry == 1) {
                num.append(carry);
                nums.add(new ListNode(carry));
            }
        }

        if (len2 < len1) {
            while (r < len1) {
                int value = Character.getNumericValue(num1.charAt(r)) + carry;
                if (value < 10) {
                    carry = 0;
                    num.append(value);
                    nums.add(new ListNode(value));
                } else {
                    carry = 1;
                    nums.add(new ListNode(value % 10));
                    num.append(value % 10);
                }
                r++;
            }
            // 加最后一次的进位
            if (carry == 1) {
                num.append(carry);
                nums.add(new ListNode(carry));
            }
        }

        if (len2 == len1 && carry == 1) {
            nums.add(new ListNode(carry));
        }

        for (int i = 1; i < nums.size(); i++) {
            nums.get(i - 1).next = nums.get(i);
        }

        System.out.println(num);
        System.out.println(nums);

        //[7,0,4,0,1]
        return nums.get(0);
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
