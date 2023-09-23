package com.leetcode.two.hundred;

/**
 * @Author: Arsenal
 * @Date: 2023-09-22 23:41
 * @Description: 填充每个节点的下一个右侧节点指针 II -中等
 * 给定一个二叉树：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，
 * 如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 * 117. Populating Next Right Pointers in Each Node II
 * Given a binary tree
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next
 * pointer to point to its next right node, just like in Figure B. The serialized output is in level
 * order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 * Input: root = []
 * Output: []
 * Constraints:
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 * Follow-up:
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */
public class S117 {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node two = new Node(20);
        Node three = new Node(30);
        Node four = new Node(40);
        root.next = two;
        two.next = three;
        three.next = four;

        Node node = connect(root);

        System.out.println(node);
    }

    public static Node connect(Node root) {

        if (root == null) {
            return root;
        }

        //cur我们可以把它看做是每一层的链表

        Node cur = root;

        while (cur != null) {

            //遍历当前层的时候，为了方便操作在下一

            //层前面添加一个哑结点（注意这里是访问

            //当前层的节点，然后把下一层的节点串起来）

            Node dummy = new Node(0);

            //pre表示访下一层节点的前一个节点

            Node pre = dummy;

            //然后开始遍历当前层的链表

            while (cur != null) {

                if (cur.left != null) {

                    //如果当前节点的左子节点不为空，就让pre节点

                    //的next指向他，也就是把它串起来

                    pre.next = cur.left;

                    //然后再更新pre

                    pre = pre.next;

                }

                //同理参照左子树

                if (cur.right != null) {

                    pre.next = cur.right;

                    pre = pre.next;

                }

                //继续访问这一行的下一个节点

                cur = cur.next;

            }

            //把下一层串联成一个链表之后，让他赋值给cur，

            //后续继续循环，直到cur为空为止

            cur = dummy.next;

        }

        return root;

    }
}
