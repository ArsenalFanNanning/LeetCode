package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2022-12-01 00:20
 * @Description: 回文数-简单
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 提示：
 * -231 <= x <= 231 - 1
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * 9. Palindrome Number
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Constraints:
 * -231 <= x <= 231 - 1
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class S009 {
    public static void main(String[] args) {
        int x = 121;
        // System.out.println(violence(x));
        System.out.println(violence(x));
    }

    public static boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    public static boolean violence(int x) {
        String s = x + "";
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
