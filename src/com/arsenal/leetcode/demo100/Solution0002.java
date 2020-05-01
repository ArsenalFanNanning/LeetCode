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
        System.out.println("=============Result=============");
        Solution0002Linked resultLinked = addTwoNumbers(firstLinked, secondLinked);
        resultLinked.list();

        System.out.println("=============Optimal=============");
        Solution0002ListNode l1 = new Solution0002ListNode(2);
        Solution0002ListNode l11 = new Solution0002ListNode(4);
        Solution0002ListNode l111 = new Solution0002ListNode(3);
        l1.next = l11;
        l11.next = l111;

        Solution0002ListNode l2 = new Solution0002ListNode(5);
        Solution0002ListNode l22 = new Solution0002ListNode(6);
        Solution0002ListNode l222 = new Solution0002ListNode(4);
        l2.next = l22;
        l22.next = l222;

        Solution0002ListNode resultNode = optimalAddTwoNumbers(l1, l2);
        while (true) {
            System.out.println(resultNode);
            if (resultNode.next == null) {
                break;
            }
            resultNode = resultNode.next;
        }
    }

    /**
     * 大佬的解决方案效率高，时间复杂度O(max(m,n))
     * https://leetcode.com/problems/add-two-numbers/discuss/1010/Is-this-Algorithm-optimal-or-what
     * <p>
     * 时间复杂度：O(max(m,n))，假设m和n分别表示l1和l2的长度，上面的算法最多重复max(m,n)次。
     * <p>
     * 空间复杂度：O(max(m,n))，新列表的长度最多为max(m,n)+1。
     * @param l1 节点1
     * @param l2 节点2
     * @return
     */
    public static Solution0002ListNode optimalAddTwoNumbers(Solution0002ListNode l1, Solution0002ListNode l2) {
        Solution0002ListNode c1 = l1;
        Solution0002ListNode c2 = l2;
        Solution0002ListNode sentinel = new Solution0002ListNode(0);
        Solution0002ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.value;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.value;
                c2 = c2.next;
            }
            d.next = new Solution0002ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new Solution0002ListNode(1);
        return sentinel.next;
    }

    /**
     * 我的方法是直接按逻辑处理，但是代码繁杂
     * @param firstLinked  链表一
     * @param secondLinked 链表二
     * @return 相加后的链表
     */
    public static Solution0002Linked addTwoNumbers(Solution0002Linked firstLinked, Solution0002Linked secondLinked) {

        if (firstLinked != null && secondLinked == null) {
            return firstLinked;
        }

        if (firstLinked == null && secondLinked != null) {
            return secondLinked;
        }

        if (firstLinked == null && secondLinked == null) {
            return null;
        }

        int firstNumber = firstLinked.getLinkedNumber();
        int secondNumber = secondLinked.getLinkedNumber();
        int total = firstNumber + secondNumber;
        System.out.println("total:" + total);
        StringBuffer sb = new StringBuffer(total + "");
        sb.reverse();
        String reverseTotal = sb.toString();
        System.out.println("reverseTotal:" + reverseTotal);
        char[] chars = reverseTotal.toCharArray();
        Solution0002Linked resultLinked = new Solution0002Linked(Integer.parseInt(chars[0] + ""));
        for (int i = 1; i < chars.length; i++) {
            resultLinked.addNode(Integer.parseInt(chars[i] + ""));
        }
        return resultLinked;
    }

}

class Solution0002Linked {
    public Solution0002ListNode head;

    Solution0002Linked(int value) {
        if (head == null) {
            head = new Solution0002ListNode(value);
        }
    }

    /**
     * 添加链表节点
     * @param value 值
     */
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

    public int getLinkedNumber() {
        StringBuffer sb = new StringBuffer();
        Solution0002ListNode temp = head;
        while (true) {
            sb.append(temp.value);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        sb.reverse();
        System.out.println("sb.toString()" + sb.toString());
        return Integer.parseInt(sb.toString());
    }

    /**
     * 获取链表长度
     * @return 链表长度
     */
    public int length() {
        int len = 0;
        if (head == null) {
            return len;
        }
        Solution0002ListNode temp = head;
        while (true) {
            len++;
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        return len;
    }

    /**
     * 遍历链表
     */
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
