package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2023-03-05 23:51
 * @Description: 二进制求和 -简单
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * 67. Add Binary
 * Given two binary strings a and b, return their sum as a binary string.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class S067 {
    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
        System.out.println(addBinaryOpt(a, b));
    }

    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public static String addBinaryOpt(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

}
