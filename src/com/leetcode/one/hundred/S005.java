package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2022-11-25 23:51
 * @Description: 最长回文子串-中等
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest
 * palindromic
 * substring
 * in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class S005 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String res = s.charAt(0) + "";
        int len = s.length();
        int l = 0, r = 0, m = 0;
        while (r < len) {
            char ch = s.charAt(r);
            int index = s.indexOf(ch, r + 1);
            while (index != -1) {
                if (isPalindrome(s.substring(l, index + 1))) {
                    if (m < index - l + 1) {
                        m = index - l + 1;
                        res = s.substring(l, index + 1);
                    }
                }
                index = s.indexOf(ch, index + 1);
            }
            l++;
            r++;
        }

        return res;
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
