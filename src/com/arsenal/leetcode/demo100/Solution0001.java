package com.arsenal.leetcode.demo100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Arsenal
 * @Date: 2020-04-30 23:10
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution0001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        //int[] subIndex = twoSum(nums, target);
        int[] subIndex = optimalTwoSum(nums, target);
        System.out.println(Arrays.toString(subIndex));
    }

    /**
     * 大佬的解决方案效率高，时间复杂度O(n)
     * https://leetcode.com/problems/two-sum/discuss/3/Accepted-Java-O(n)-Solution
     * <p>
     * 复杂度分析：
     * <p>
     * 时间复杂度：O(n)，
     * 我们只遍历了包含有n个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
     * <p>
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储n个元素。
     * @param nums   数组
     * @param target 和
     * @return 下标数组
     */
    public static int[] optimalTwoSum(int[] nums, int target) {
        if (nums.length < 3) {
            return null;
        }

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 我的方法比较容易理解，但是效率较低，时间复杂度O(n^2)
     * <p>
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n2)。
     * 空间复杂度：O(1)。
     * @param nums   数组
     * @param target 和
     * @return 下标数组
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 3) {
            return null;
        }
        int[] subIndex = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    subIndex[0] = i;
                    subIndex[1] = j;
                }
            }
        }
        return subIndex;
    }
}
