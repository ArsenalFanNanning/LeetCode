package com.leetcode.one.hundred;

/**
 * @Author: Arsenal
 * @Date: 2022-12-07 00:09
 * @Description: 最长公共前缀-简单
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class S014 {
    public static void main(String[] args) {
        //String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = compare(prefix, strs[i]);
        }
        return prefix;
    }

    private static String compare(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < len) {
            if (s1.charAt(index) != s2.charAt(index)) {
                break;
            }
            index++;
        }
        return s1.substring(0, index);
    }
}
