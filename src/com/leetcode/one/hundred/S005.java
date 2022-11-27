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
        String s = "babad";
        // System.out.println(violence(s));
        System.out.println(optimize(s));
       // System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static String optimize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        //  保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        // 查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        // 定位中间部分的最后一个字符
        int ans = high;
        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public static String violence(String s) {
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
