package com.leetcode.two.hundred;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Arsenal
 * @Date: 2023-09-14 23:58
 * @Description: 填充每个节点的下一个右侧节点指针 -中等
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，
 * 如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 * 116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node,
 * just like in Figure B. The serialized output is in level order
 * as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 * Input: root = []
 * Output: []
 * Constraints:
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 * Follow-up:
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */
public class S116 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        root.next = two;
        two.next = three;
        three.next = four;

        //Node node = connect(root);
        Node node = connectOpt(root);

        System.out.println(node);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }


    public static Node connectOpt(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }

}
