/**
 * Leetcode - rotate_array
 */
package com.duol.leetcode.y21.m1.d8.no189.rotate_array;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution3 implements Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 全翻转
        reverse(nums, 0, nums.length - 1);
        // 翻转前部分
        reverse(nums, 0, k - 1);
        // 翻转后部分
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
