package com.leetcode.one.hundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Arsenal
 * @Date: 2022-11-24 23:32
 * @Description: 无重复字符的最长子串-中等
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class S003 {
    public static void main(String[] args) {
        String s = "pwwkew";
        //System.out.println(violence(s));
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 每次左指针右移一位，移除set的一个字符，这一步会导致很多无用的循环。while循环发现的重复字符不一定就是Set最早添加那个，
        // 还要好多次循环才能到达，这些都是无效循环，不如直接用map记下每个字符的索引，直接进行跳转
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        System.out.println(map);
        return max;
    }

    private static int violence(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int r = 0, start = 0, m = 0;
        while (r < len) {
            char ch = s.charAt(r);
            if (!set.contains(ch)) {
                set.add(ch);
                if (set.size() == 1) {
                    start = r;
                }
                m = Math.max(m, r - start + 1);
            } else {
                r = start;
                set.clear();
            }

            r++;
        }

        return m;
    }
}
