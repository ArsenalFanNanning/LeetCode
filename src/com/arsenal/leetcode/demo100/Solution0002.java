package com.arsenal.leetcode.demo100;

/**
 * @Auther: Arsenal
 * @Date: 2020-05-01 13:39
 * @Description:给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807。
 */
public class Solution0002 {
    public static void main(String[] args) {
        Solution0002Linked firstLinked = new Solution0002Linked(2);
        firstLinked.addNode(4);
        firstLinked.addNode(3);
        Solution0002Linked secondLinked = new Solution0002Linked(5);
        secondLinked.addNode(6);
        secondLinked.addNode(4);
        System.out.println("firstLinked:");
        firstLinked.list();
        System.out.println("secondLinked:");
        secondLinked.list();
    }

    public static Solution0002Linked addTwoNumbers(Solution0002Linked firstLinked, Solution0002Linked secondLinked) {
        return null;
    }
}

class Solution0002Linked {
    public Solution0002ListNode head;

    Solution0002Linked(int value) {
        if (head == null) {
            head = new Solution0002ListNode(value);
        }
    }

    public void addNode(int value) {
        if (head == null) {
            return;
        }
        Solution0002ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = new Solution0002ListNode(value);
    }

    public void list() {
        if (head == null) {
            System.out.println("Empty Linked");
            return;
        }
        Solution0002ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.print(temp + "\t");
            temp = temp.next;
        }
        System.out.print(temp + "\t");
        System.out.println();
    }
}

class Solution0002ListNode {
    public int value;
    public Solution0002ListNode next;

    Solution0002ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}
